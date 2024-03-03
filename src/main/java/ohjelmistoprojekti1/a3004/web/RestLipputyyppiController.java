package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<Lipputyyppi> uusiLipputyyppi(@RequestBody Lipputyyppi uusiLipputyyppi) {
        Lipputyyppi tallennettuLipputyyppi = lipputyyppiRepository.save(uusiLipputyyppi);
        return ResponseEntity.ok(tallennettuLipputyyppi);
    } 
}
