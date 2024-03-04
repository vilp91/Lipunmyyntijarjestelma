package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/lipputyypit")
    public Lipputyyppi luoLipputyyppi(@RequestBody Lipputyyppi lipputyyppi) {
        return lipputyyppiRepository.save(lipputyyppi);
    }

    @DeleteMapping("/lipputyypit/{id}")
    public ResponseEntity<?> poistaLipputyyppi(@PathVariable("id") Long id) {
        // tarkistetaan, onko tietokannassa annettua id:tä vastaava lipputyyppi
        if (lipputyyppiRepository.existsById(id)) {
            // jos lipputyyppi on olemassa, se poistetaan
            lipputyyppiRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/lipputyypit/{id}")
    public ResponseEntity<?> muokkaaLipputyyppi(@PathVariable("id") Long id,
            @RequestBody Lipputyyppi muokattuLipputyyppi) {
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