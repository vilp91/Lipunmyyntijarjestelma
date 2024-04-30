package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;
import ohjelmistoprojekti1.a3004.domain.Tapahtuma;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;

@RestController
public class RestLippuController {

    @Autowired
    LippuRepository lippuRepository;

    @Autowired
    TapahtumaRepository tapahtumaRepository;

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
