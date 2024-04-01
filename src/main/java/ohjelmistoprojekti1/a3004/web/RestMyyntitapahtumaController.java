package ohjelmistoprojekti1.a3004.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.Tapahtuma;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppiRepository;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RestMyyntitapahtumaController {

    @Autowired
    MyyntitapahtumaRepository myyntitapahtumaRepository;
    @Autowired
    LippuRepository lippuRepository;
    @Autowired
    RestLippuController lippuController;

    @Autowired
    TapahtumanLipputyyppiRepository tapahtumanLipputyyppiRepository;

    @Autowired
    TapahtumaRepository tapahtumaRepository;

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/myyntitapahtumat")
    public ResponseEntity<List<MyyntitapahtumaDTO>> haeKaikkiMyyntitapahtumat() {
        // hakee kaikki myyntitapahtumat
        Iterable<Myyntitapahtuma> myyntitapahtumat = myyntitapahtumaRepository.findAll();
        List<MyyntitapahtumaDTO> myyntitapahtumaDTOLista = new ArrayList<>();

        // käy läpi haetut myyntitapahtumat
        for (Myyntitapahtuma myyntitapahtuma : myyntitapahtumat) {
            // muutetaan myyntitapahtumat DTO versioiksi
            MyyntitapahtumaDTO myyntitapahtumaDTO = EntitytoDTO(myyntitapahtuma);
            myyntitapahtumaDTO.setId(myyntitapahtuma.getMyyntitapahtuma_id());
            // lisätään MyyntitapahtumaDTO listaan
            myyntitapahtumaDTOLista.add(myyntitapahtumaDTO);
        }

        // jos listaa ei löydy annetaan 404
        if (myyntitapahtumaDTOLista.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            // jos löytyy annetaan 200
            return ResponseEntity.ok(myyntitapahtumaDTOLista);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/myyntitapahtumat/{id}")
    public ResponseEntity<?> haeMyyntitapahtuma(@PathVariable("id") Long id) {
        // tarkistaa, että tietokannassa on tietue annetulla id:llä
        // jos ei, niin palauttaa koodin 404
        if (!myyntitapahtumaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa syötetyllä id:llä '" + id + "'', ei löydy");
        }
        // hakee myyntitapahtuman tiedot
        Myyntitapahtuma myyntitapahtuma = myyntitapahtumaRepository.findById(id).orElse(null);

        // luo uuden DTO-version
        MyyntitapahtumaDTO myyntitapahtumaDTO = EntitytoDTO(myyntitapahtuma);
        myyntitapahtumaDTO.setId(id);
        return ResponseEntity.ok().body(myyntitapahtumaDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @PostMapping("/myyntitapahtumat")
    @Transactional
    public ResponseEntity<?> myyLippuja(@Valid @RequestBody List<OstettuLippuDTO> ostetutLiputDTO) {
        Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma();
        myyntitapahtuma.setKayttaja(null); // voisko tämä tulla polkumuuttujana?
        myyntitapahtumaRepository.save(myyntitapahtuma);

        for (OstettuLippuDTO ostettuLippuDTO : ostetutLiputDTO) {
            for (int i = 0; i < ostettuLippuDTO.getMaara(); i++) {
                if (!tapahtumanLipputyyppiRepository.existsById(ostettuLippuDTO.getTapahtumanLipputyyppi())) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Tapahtuman lipputyypin valinnassa virhe. Tarkista onko lipputyyppiä valitulla id:llä olemassa GET /tapahtumanlipputyypit - Myyntitapahtuma on peruttu.");
                }

                Tapahtuma tapahtuma = (tapahtumanLipputyyppiRepository
                        .findById(ostettuLippuDTO.getTapahtumanLipputyyppi()).orElse(null)).getTapahtuma();

                if (tapahtuma.getMyydyt_liput_lukum() + 1 > tapahtuma.getLippu_lukum()) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Yksi tai useampi lippu ei ollut saatavilla. Myyntitapahtuma on peruttu.");
                }

                tapahtuma.setMyydyt_liput_lukum(tapahtuma.getMyydyt_liput_lukum() + 1);
                Lippu lippu = new Lippu();
                lippu.setTapahtuman_lipputyyppi(tapahtumanLipputyyppiRepository
                        .findById(ostettuLippuDTO.getTapahtumanLipputyyppi()).orElse(null));
                lippu.setMyyntitapahtuma(myyntitapahtuma);
                lippu.setHinta(lippu.getTapahtuman_lipputyyppi().getHinta());
                lippuRepository.save(lippu);
            }
        }
        MyyntitapahtumaDTO myyntitapahtumaDTO = EntitytoDTO(myyntitapahtuma);
        myyntitapahtumaDTO.setId(myyntitapahtuma.getMyyntitapahtuma_id());
        return ResponseEntity.status(HttpStatus.CREATED).body(myyntitapahtumaDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/myyntitapahtumat/{id}")
    public ResponseEntity<?> poistaMyyntitapahtuma(@PathVariable("id") Long id) {
        // tarkistetaan löytyykö tietokannasta tietuetta annetulla id:llä
        if (myyntitapahtumaRepository.existsById(id)) {
            // jos tietue löytyy haetaan siihen liittyvät liput ja poistetaan ne
            Myyntitapahtuma myyntitapahtuma = myyntitapahtumaRepository.findById(id).orElse(null);
            List<Lippu> liput = myyntitapahtuma.getLiput();
            for (Lippu lippu : liput) {
                lippuController.poistaLippu(lippu.getLippu_id());
            }
            // poistetaan myyntitapahtuma
            myyntitapahtumaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        // jos tietuetta ei löydy, vastataan koodilla 404
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Myyntitapahtumaa syötetyllä id:llä '" + id + "', ei löydy :(");
    }

    private MyyntitapahtumaDTO EntitytoDTO(Myyntitapahtuma myyntitapahtuma) {
        MyyntitapahtumaDTO myyntitapahtumaDTO = new MyyntitapahtumaDTO();
        myyntitapahtumaDTO.setAika(myyntitapahtuma.getAikaleima());
        // hakee tietokannasta myyntitapahtumaan liittyvät liput
        List<Lippu> liput = lippuRepository.findByMyyntitapahtuma(myyntitapahtuma);
        // luo listan lippujen DTO-versioille
        List<LippuDTO> lippuDTOLista = new ArrayList<>();
        float summa = 0;
        for (Lippu lippu : liput) {
            LippuDTO lippuDTO = new LippuDTO();
            // id:n lisäys
            lippuDTO.setId(lippu.getLippu_id());
            // lipputyypin lisäys
            lippuDTO.setTyyppi(lippu.getTapahtuman_lipputyyppi().getLipputyyppi().getTyyppi());
            lippuDTO.setTapahtuma(lippu.getTapahtuman_lipputyyppi().getTapahtuma().getTapahtuman_nimi());
            lippuDTO.setHinta(lippu.getHinta());
            summa += lippu.getHinta();
            lippuDTOLista.add(lippuDTO);
        }
        // asettaa listan myyntitapahtuman DTO-versioon
        myyntitapahtumaDTO.setLiput(lippuDTOLista);
        myyntitapahtumaDTO.setSumma(summa);
        return myyntitapahtumaDTO;
    }
<<<<<<< HEAD

    @PostMapping("/myyntitapahtumat")
    @Transactional
    public ResponseEntity<?> myyLippuja(@RequestBody List<OstettuLippuDTO> ostetutLiputDTO) {
        // try {
            // luodaan uusi myyntitapahtuma ja asetetaan sille käyttäjätieto
            Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma();
            myyntitapahtuma.setKayttaja(null); // voisko tämä tulla polkumuuttujana?

            // tallennetaan myyntitapahtuma niin saadaan sille id
            myyntitapahtumaRepository.save(myyntitapahtuma);

            // käydään pyynnön rungossa saatu OstettuLippuDTO-olioiden lista läpi ja
            // muodostetaan niistä lippuja
            for (OstettuLippuDTO ostettuLippuDTO : ostetutLiputDTO) {
                // muodostetaan niin monta saman tapahtumanlipputyypin lippua, kuin on ostettu
                for (int i = 0; i < ostettuLippuDTO.getMaara(); i++) {
                    // varmistetaan, ettei myydä enempää lippuja, kuin saatavilla on:
                    // haetaan tapahtuma, johon lippua ollaan myymässä
                    Tapahtuma tapahtuma = (tapahtumanLipputyyppiRepository
                            .findById(ostettuLippuDTO.getTapahtumanLipputyyppi()).orElse(null)).getTapahtuma();
                    // tarkistetaan, onko lippu saatavilla
                    if (tapahtuma.getMyydyt_liput_lukum() + 1 <= tapahtuma.getLippu_lukum()) {
                        // jos lippu on saatavilla, lisätään myytyjen lippujen määrä yhdellä ja luodaan lippu
                        tapahtuma.setMyydyt_liput_lukum(tapahtuma.getMyydyt_liput_lukum() + 1);
                        Lippu lippu = new Lippu();
                        lippu.setTapahtuman_lipputyyppi(tapahtumanLipputyyppiRepository
                                .findById(ostettuLippuDTO.getTapahtumanLipputyyppi())
                                .orElseThrow(() -> new RuntimeException(
                                        "TapahtumanLipputyyppi not found with id "
                                                + ostettuLippuDTO.getTapahtumanLipputyyppi())));
                        lippu.setMyyntitapahtuma(myyntitapahtuma);
                        lippu.setHinta(lippu.getTapahtuman_lipputyyppi().getHinta());
                        lippuRepository.save(lippu);
                    }
                    // jos jotain lippua ei ole saatavilla, annetaan virheilmoitus ja perutaan tehdyt muutokset tietokantaan
                    else {
                        throw new RuntimeException("Yksi tai useampi lippu ei ollut saatavilla. Myyntitapahtuma on peruttu.");
                    }
                }
            }
            // muutetaan myyntitapahtuma DTO-versioksi
            MyyntitapahtumaDTO myyntitapahtumaDTO = EntitytoDTO(myyntitapahtuma);
            // lisätään DTO-versioon id ja tallennetaan se
            myyntitapahtumaDTO.setId(myyntitapahtuma.getMyyntitapahtuma_id());
            return ResponseEntity.status(HttpStatus.CREATED).body(myyntitapahtumaDTO);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Jokin meni vikaan :(");
        // }
    }

    @DeleteMapping("/myyntitapahtumat/{id}")
    public ResponseEntity<?> poistaMyyntitapahtuma(@PathVariable("id") Long id) {
        // tarkistetaan löytyykö tietokannasta tietuetta annetulla id:llä
        if (myyntitapahtumaRepository.existsById(id)) {
            // jos tietue löytyy, se poistetaan ja vastataan koodilla 204
            myyntitapahtumaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        // jos tietuetta ei löydy, vastataan koodilla 404
        return ResponseEntity.notFound().build();
    }
=======
>>>>>>> dev
}
