package ohjelmistoprojekti1.a3004.web;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;
import ohjelmistoprojekti1.a3004.domain.Tapahtuma;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppi;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppiRepository;

@RestController
public class RestLippuController {

    @Autowired
    LippuRepository lippuRepository;

    @Autowired
    TapahtumaRepository tapahtumaRepository;

    @Autowired
    TapahtumanLipputyyppiRepository tapahtumanLipputyyppiRepository;

    // @CrossOrigin
    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_LIPUNTARKASTAJA')")
    @GetMapping("/liput")
    public Iterable<Lippu> haeLiput(
            @RequestParam(value = "lippunumero", required = false) Optional<String> lippunumero) {
        // tarkistetaan onko pyynnön mukana annettu parametria
        if (lippunumero.isPresent()) {
            // tarkistetaan onko annettu parametri tyhjä
            if (lippunumero.get() == "") {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pyynnössä ei ole lippunumeroa");
            } else {
                UUID lippunumeroUuid = UUID.fromString(lippunumero.get());
                // tarkistetaan löytyykö annetulla parametrilla lippua
                if (lippuRepository.existsByLippunumeroAndPoistettuFalse(lippunumeroUuid)) {
                    return lippuRepository.findByLippunumero(lippunumeroUuid);
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            }
        }
        // palautetaan kaikki liput, jos parametria ei ole annettu
        return lippuRepository.findByPoistettuFalse();
    }

    // tapahtuman loppujen lippujen luonti
    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @PostMapping("/liput/{id}")
    public ResponseEntity<?> luoLoputLiput(
            @PathVariable("id") Long tapahtumaId,
            @RequestParam(value = "lipputyyppiId", required = false) Long lipputyyppiId) {

        // tarkistaa onko tietokannassa aktiivista tapahtumaa annetulla id:llä
        if (!tapahtumaRepository.existsByTapahtumaIdAndPoistettuFalse(tapahtumaId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa annetulla id:llä: " + tapahtumaId + " ei löydy");
        }

        // hakee tapahtuman ja luo vapaatLiput muuttujan
        Tapahtuma tapahtuma = tapahtumaRepository.findById(tapahtumaId).get();
        int vapaatLiput = tapahtuma.getLippuLukum() - tapahtuma.getMyydytLiputLukum();

        // tarkistaa onko tapahtumaan jäljellä myymättömiä lippuja
        if (vapaatLiput <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ei lisättäviä lippuja, kaikki liput on jo luotu");
        }

        // etsii onko annetulla lipputyyppiId:llä lipputyyppiä tapahtumassa.
        List<TapahtumanLipputyyppi> tapahtumanlipputyyppit = tapahtumanLipputyyppiRepository.findByLipputyyppiLipputyyppiId(lipputyyppiId);
        TapahtumanLipputyyppi tapahtumanLipputyyppi = null;
        if (lipputyyppiId != null) {
            for (TapahtumanLipputyyppi tapahtumanLipputyyppiX : tapahtumanlipputyyppit) {
                if (tapahtumanLipputyyppiX.getTapahtuma().getTapahtumaId().equals(tapahtumaId)) {
                    tapahtumanLipputyyppi = tapahtumanLipputyyppiX;
                }
            }
            if (tapahtumanLipputyyppi == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ei lipputyyppiä annetulla lipputyyppiId:llä " + lipputyyppiId);
            }
        }

        // oletusarvon asettaminen, perus, jos lipputyyppiId:tä ei annettu
        if (lipputyyppiId == null) {
            List<TapahtumanLipputyyppi> tapahtumanlipputyypit = tapahtumanLipputyyppiRepository.findByTapahtuma(tapahtuma);
            for (TapahtumanLipputyyppi tapahtumanLipputyyppiX : tapahtumanlipputyypit) {
                if (tapahtumanLipputyyppiX.getLipputyyppi().getTyyppi().equals("perus")) {
                    tapahtumanLipputyyppi = tapahtumanLipputyyppiX;
                }
            }
            if (tapahtumanLipputyyppi == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tapahtumalle ei löytynyt oletuslipputyyppiä 'perus'");
            }
        }

        // luo vapaat liput ja tallentaa ne tietokantaan, sekä päivittää tapahtuman myytyjen lippujen osalta.
        List<Lippu> liput = new ArrayList<>();
        while (vapaatLiput > 0) {
            // 
            Lippu lippu = new Lippu(tapahtumanLipputyyppi, tapahtumanLipputyyppi.getHinta());

            liput.add(lippu);
            vapaatLiput--;
        }

        liput = (List<Lippu>) lippuRepository.saveAll(liput);

        tapahtuma.setMyydytLiputLukum(tapahtuma.getMyydytLiputLukum() + liput.size());
        tapahtumaRepository.save(tapahtuma);

            URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .build()
            .toUri();

        return ResponseEntity.created(location).body(liput);
    }

    // @CrossOrigin
    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_LIPUNTARKASTAJA')")
    @GetMapping("/liput/{id}")
    public ResponseEntity<?> haeLippu(@PathVariable("id") Long id) {
        // tarkistaa, että tietokannassa on tietue annetulla id:llä
        // jos ei, niin palauttaa koodin 404
        if (!lippuRepository.existsByLippuIdAndPoistettuFalse(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lippua syötetyllä id:llä: " + id + ", ei löydy");
        }
        // hakee lipun tiedot
        Lippu lippu = lippuRepository.findById(id).get();
        return ResponseEntity.ok().body(lippu);
    }

    // @CrossOrigin
    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_LIPUNTARKASTAJA')")
    @PatchMapping("/liput/{id}")
    public ResponseEntity<?> merkitseLippuKaytetyksi(@PathVariable("id") Long lippuId, @RequestBody Lippu patchLippu) {
        Optional<Lippu> lippu = lippuRepository.findByLippuIdAndPoistettuFalse(lippuId);
        LocalDateTime aika = patchLippu.getKaytetty();

        if (lippu.isPresent()) {
            if (lippu.get().getKaytetty() == null) {
                lippu.get().setKaytetty(aika);
                lippuRepository.save(lippu.get());
                return ResponseEntity.ok().body(lippu.get());
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lippu on jo käytetty");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarkista lippuId");
        }
    }

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/liput/{id}")
    public ResponseEntity<?> poistaLippu(@PathVariable("id") Long id) {
        // tarkistetaan, että tietokannassa on haettu tietue ja haetaan se
        if (lippuRepository.existsByLippuIdAndPoistettuFalse(id)) {
            Lippu lippu = lippuRepository.findById(id).get();

            // vähennetään tapahtuman myydyistä lipuista 1 ja poistetaan lippu
            Tapahtuma tapahtuma = lippu.getTapahtumanLipputyyppi().getTapahtuma();
            tapahtuma.setMyydytLiputLukum(tapahtuma.getMyydytLiputLukum() - 1);
            lippu.setPoistettu(true);
            lippuRepository.save(lippu);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

}
