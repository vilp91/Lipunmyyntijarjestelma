package ohjelmistoprojekti1.a3004.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;

/* @RestController
public class RestMyyntitapahtumaController {

    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    @Autowired
    private MyyntitapahtumaService myyntitapahtumaService;


    @GetMapping("/myyntitapahtumat")
    public Iterable<Myyntitapahtuma> haeMyyntitapahtumat() {
        return myyntitapahtumaRepository.findAll();
    }

    @PostMapping("/myyntitapahtumat")
    public ResponseEntity<Myyntitapahtuma> uusiMyyntiTapahtuma(@RequestBody Myyntitapahtuma uusiMyyntitapahtuma) {
    Myyntitapahtuma tallennettuMyyntiTapahtuma = myyntitapahtumaRepository.save(uusiMyyntitapahtuma);
        return ResponseEntity.ok(tallennettuMyyntiTapahtuma);
    }   

    @PostMapping("/transactions/myy-lippu")
    public ResponseEntity<Myyntitapahtuma> myyLippu(@RequestBody Myyntitapahtuma myyntitapahtuma) {
        
        Myyntitapahtuma luotuMyyntitapahtuma = MyyntitapahtumaService.createMyyntitapahtuma(myyntitapahtuma);

       
        return ResponseEntity.ok(luotuMyyntitapahtuma);
    }
}*/
