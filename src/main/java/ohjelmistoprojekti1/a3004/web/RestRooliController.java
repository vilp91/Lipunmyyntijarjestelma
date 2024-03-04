package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Rooli;
import ohjelmistoprojekti1.a3004.domain.RooliRepository;

@RestController
public class RestRooliController {

    @Autowired
    private RooliRepository rooliRepository;

    @GetMapping("/roolit")
    public Iterable<Rooli> haeRoolit() {
        return rooliRepository.findAll();
    }

}
