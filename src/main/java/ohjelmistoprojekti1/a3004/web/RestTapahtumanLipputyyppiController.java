package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppi;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppiRepository;

@RestController
public class RestTapahtumanLipputyyppiController {

    @Autowired
    private TapahtumanLipputyyppiRepository tapahtumanlipputyyppiRepository;

    @GetMapping("/tapahtumanlipputyypit")
    public Iterable<TapahtumanLipputyyppi> haeTapahtumanLipputyypit() {
        return tapahtumanlipputyyppiRepository.findAll();
    }

    @PostMapping("/tapahtumanlipputyypit")
    public ResponseEntity<TapahtumanLipputyyppi> uusiTapahtumanLipputyyppi(@RequestBody TapahtumanLipputyyppi uusiTapahtumanLipputyyppi) {
        TapahtumanLipputyyppi tallennettuTapahtumanlipputyyppi = tapahtumanlipputyyppiRepository.save(uusiTapahtumanLipputyyppi);
        return ResponseEntity.ok(tallennettuTapahtumanlipputyyppi);
    } 
    
}