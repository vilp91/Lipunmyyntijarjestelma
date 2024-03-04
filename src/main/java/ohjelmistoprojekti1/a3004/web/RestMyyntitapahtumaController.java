package ohjelmistoprojekti1.a3004.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppiRepository;

@RestController
public class RestMyyntitapahtumaController {

    @Autowired
    MyyntitapahtumaRepository myyntitapahtumaRepository;
    @Autowired
    LippuRepository lippuRepository;
    @Autowired
    TapahtumanLipputyyppiRepository tapahtumanLipputyyppiRepository;

    @GetMapping("/myyntitapahtumat")
    public List<MyyntitapahtumaDTO> haeKaikkiMyyntitapahtumat() {
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

        return myyntitapahtumaDTOLista;
    }


    @GetMapping("/myyntitapahtumat/{id}")
    public MyyntitapahtumaDTO haeMyyntitapahtuma(@PathVariable("id") Long id) {
        // hakee myyntitapahtuman tiedot
        Myyntitapahtuma myyntitapahtuma = myyntitapahtumaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Myyntitapahtuma not found with id " + id));

        // luo uuden DTO-version
        MyyntitapahtumaDTO myyntitapahtumaDTO = EntitytoDTO(myyntitapahtuma);
        myyntitapahtumaDTO.setId(id);
        return myyntitapahtumaDTO;
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

    @PostMapping("/myynti")
    public MyyntitapahtumaDTO myyLippuja(@RequestBody List<OstettuLippuDTO> ostetutLiputDTO) {
        // luodaan uusi myyntitapahtuma ja asetetaan sille käyttäjätieto (kunhan tietäis
        // mistä se saadaan :D
        Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma();
        myyntitapahtuma.setKayttaja(null); // voisko tämä tulla polkumuuttujana?

        // tallennetaan myyntitapahtuma niin saadaan sille id
        myyntitapahtumaRepository.save(myyntitapahtuma);

        // käydään pyynnön rungossa saatu OstettuLippuDTO-olioiden lista läpi ja
        // muodostetaan niistä lippuja
        for (OstettuLippuDTO ostettuLippuDTO : ostetutLiputDTO) {
            // muodostetaan niin monta saman tapahtumanlipputyypin lippua, kuin on ostettu
            for (int i = 0; i < ostettuLippuDTO.getMaara(); i++) {
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
        }
        // muutetaan myyntitapahtuma DTO-versioksi
        MyyntitapahtumaDTO myyntitapahtumaDTO = EntitytoDTO(myyntitapahtuma);
        // lisätään DTO-versioon id ja tallennetaan se
        myyntitapahtumaDTO.setId(myyntitapahtuma.getMyyntitapahtuma_id());
        return myyntitapahtumaDTO;

    }
}
