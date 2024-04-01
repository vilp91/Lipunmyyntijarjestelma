package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/liput")
    public Iterable<Lippu> haeLiput() {
        return lippuRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/liput/{id}")
    public ResponseEntity<?> haeLippu(@PathVariable("id") Long id) {
        // tarkistaa, että tietokannassa on tietue annetulla id:llä
        // jos ei, niin palauttaa koodin 404
        if (!lippuRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lippua syötetyllä id:llä: " + id + ", ei löydy");
        }
        // hakee lipun tiedot
        Lippu lippu = lippuRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(lippu);
    }

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/liput/{id}")
    public ResponseEntity<?> poistaLippu(@PathVariable("id") Long id) {
        // tarkistetaan, että tietokannassa on haettu tietue ja haetaan se
        if (lippuRepository.existsById(id)) {
            Lippu lippu = lippuRepository.findById(id).orElse(null);

            // vähennetään tapahtuman myydyistä lipuista 1 ja poistetaan lippu
            Tapahtuma tapahtuma = lippu.getTapahtuman_lipputyyppi().getTapahtuma();
            tapahtuma.setMyydyt_liput_lukum(tapahtuma.getMyydyt_liput_lukum() - 1);
            lippuRepository.delete(lippu);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

}
