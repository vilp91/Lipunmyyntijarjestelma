package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;

@RestController
public class RestLippuController {

    @Autowired
    LippuRepository lippuRepository;

    @GetMapping("/liput")
    public Iterable<Lippu> haeLiput() {
        return lippuRepository.findAll();
    }

}
