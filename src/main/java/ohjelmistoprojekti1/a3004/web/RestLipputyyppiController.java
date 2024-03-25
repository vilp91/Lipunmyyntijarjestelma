package ohjelmistoprojekti1.a3004.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import ohjelmistoprojekti1.a3004.domain.Lipputyyppi;
import ohjelmistoprojekti1.a3004.domain.LipputyyppiRepository;

@RestController
public class RestLipputyyppiController {

    @Autowired
    private LipputyyppiRepository lipputyyppiRepository;

    @GetMapping("/lipputyypit")
    public Iterable<Lipputyyppi> haeLipputyypit() {
        return lipputyyppiRepository.findAll();
    }

    @GetMapping("/lipputyypit/{id}")
    public ResponseEntity<?> haeLippulipputyyppi(@PathVariable("id") Long id) {
        // tarkistaa, että tietokannassa on tietue annetulla id:llä
        // jos ei, niin palauttaa koodin 404
        if (!lipputyyppiRepository.existsById(id)) {
            String errorMessage = "Lipputyyppiä syötetyllä id:llä: " + id + ", ei löydy :(";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        // hakee lipputyypin tiedot
        Lipputyyppi lipputyyppi = lipputyyppiRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(lipputyyppi);

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/lipputyypit")
    public ResponseEntity<?> luoLipputyyppi(@Valid @RequestBody Lipputyyppi lipputyyppi) {
        Lipputyyppi tallennettuLipputyyppi = lipputyyppiRepository.save(lipputyyppi);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tallennettuLipputyyppi.getLipputyyppi_id())
                .toUri();
        return ResponseEntity.created(location).body(tallennettuLipputyyppi);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/lipputyypit/{id}")
    public ResponseEntity<?> poistaLipputyyppi(@PathVariable("id") Long id) {
        // tarkistetaan, onko tietokannassa annettua id:tä vastaava lipputyyppi
        if (lipputyyppiRepository.existsById(id)) {
            // jos lipputyyppi on olemassa, se poistetaan
            lipputyyppiRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/lipputyypit/{id}")
    public ResponseEntity<?> muokkaaLipputyyppi(@PathVariable("id") Long id,
            @Valid @RequestBody Lipputyyppi muokattuLipputyyppi) {
        // tarkistetaan, onko tietokannassa annettua id:tä vastaava lipputyyppi
        if (lipputyyppiRepository.existsById(id)) {
            // jos lipputyyppi on olemassa, se päivitetään annetuilla tiedoilla
            muokattuLipputyyppi.setLipputyyppi_id(id);
            lipputyyppiRepository.save(muokattuLipputyyppi);
            return ResponseEntity.ok().body(muokattuLipputyyppi);
        }
        return ResponseEntity.notFound().build();
    }

}
