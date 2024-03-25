package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;

@RestController
public class RestLippuController {

    @Autowired
    LippuRepository lippuRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/liput")
    public Iterable<Lippu> haeLiput() {
        return lippuRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/liput/{id}")
    public ResponseEntity<?> haeLippu(@PathVariable("id") Long id) {
        // tarkistaa, että tietokannassa on tietue annetulla id:llä
        // jos ei, niin palauttaa koodin 404
        if (!lippuRepository.existsById(id)) {
            String errorMessage = "Lippua syötetyllä id:llä: " + id + ", ei löydy :(";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        // hakee lipun tiedot
        Lippu lippu = lippuRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(lippu);

    }

}
