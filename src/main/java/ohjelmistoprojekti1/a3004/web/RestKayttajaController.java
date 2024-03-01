package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.KayttajaRepository;

@RestController
public class RestKayttajaController {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    private final KayttajaService kayttajaService;

    public RestKayttajaController(KayttajaService kayttajaService) {
        this.kayttajaService = kayttajaService;
    }

    @GetMapping("/kayttajat")
    public Iterable<Kayttaja> haeKayttajat() {
        return kayttajaRepository.findAll();
    }

}
