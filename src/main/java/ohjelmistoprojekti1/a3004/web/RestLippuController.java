package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;

@RestController
public class RestLippuController {

     @Autowired
    private LippuRepository lippuRepository;

     @GetMapping("/lippu")
    public Iterable<Lippu> haeLiput() {
        return lippuRepository.findAll();
    }

    @PostMapping("/lippu")
    public ResponseEntity<Lippu> createLippu(@RequestBody Lippu lippu) {
        Lippu newLippu = lippuRepository.save(lippu);
        return new ResponseEntity<>(newLippu, HttpStatus.CREATED);
    }

}
