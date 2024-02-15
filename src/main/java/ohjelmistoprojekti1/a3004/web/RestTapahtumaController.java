package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Tapahtuma;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;

@RestController
public class RestTapahtumaController {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @GetMapping("/tapahtumat")
    public Iterable<Tapahtuma> haeTapahtumat() {
        return tapahtumaRepository.findAll();
    }

    @PostMapping("/tapahtumat")
    Tapahtuma uusiTapahtuma(@RequestBody Tapahtuma uusiTapahtuma) {
        return tapahtumaRepository.save(uusiTapahtuma);
    }

    @PutMapping("/tapahtumat/{id}")
    Tapahtuma muokattuTapahtuma(@PathVariable("id") Long id, @RequestBody Tapahtuma muokattuTapahtuma) {
        muokattuTapahtuma.setTapahtuma_id(id);
        return tapahtumaRepository.save(muokattuTapahtuma);
    }

    @DeleteMapping("/tapahtumat/{id}")
    public void poistaTapahtuma(@PathVariable("id") Long id) {
        tapahtumaRepository.deleteById(id);
    }
    
}
