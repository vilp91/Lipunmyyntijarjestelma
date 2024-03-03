package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;

@RestController
public class RestMyyntitapahtumaController {

    
    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    @GetMapping("/myyntitapahtumat")
    public Iterable<Myyntitapahtuma> haeMyyntitapahtumat() {
        return myyntitapahtumaRepository.findAll();
    }

    @PostMapping("/myyntitapahtumat")
    public ResponseEntity<Myyntitapahtuma> uusiMyyntitapahtuma(@RequestBody Myyntitapahtuma uusiMyyntitapahtuma) {
        Myyntitapahtuma tallennettuMyyntitapahtuma = myyntitapahtumaRepository.save(uusiMyyntitapahtuma);
        return ResponseEntity.ok(tallennettuMyyntitapahtuma);
    } 
}