package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // haetaan tapahtumat, joiden alku on kuluvan vuorokauden jälkeen
    @GetMapping("/tapahtumat/tulevat")
    public Iterable<Tapahtuma> tulevatTapahtumat() {
        // haetaan vertailuajaksi kuluvan vuorokauden viimeinen hetki
        LocalDateTime tanaan = LocalDateTime.now().with(LocalTime.MAX);
        return tapahtumaRepository.findAllByAlkuAfter(tanaan);
    }

    // @PostMapping("/tapahtumat")
    // Tapahtuma uusiTapahtuma(@RequestBody Tapahtuma uusiTapahtuma) {
    //     return tapahtumaRepository.save(uusiTapahtuma);
    // }
    @PostMapping("/tapahtumat")
    public ResponseEntity<Tapahtuma> uusiTapahtuma(@RequestBody Tapahtuma uusiTapahtuma) {
        // tarkistetaan, onko tapahtumalle annettu nimi. Jos ei, palautetaan 400 - bad request
        if (uusiTapahtuma.getTapahtuman_nimi() == null || uusiTapahtuma.getTapahtuman_nimi().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        // jos tapahtumalle on annettu nimi, palautetaan 200 - ok
        tapahtumaRepository.save(uusiTapahtuma);
        return ResponseEntity.ok(uusiTapahtuma);
    }

    @PutMapping("/tapahtumat/{id}")
    Tapahtuma muokattuTapahtuma(@PathVariable("id") Long id, @RequestBody Tapahtuma muokattuTapahtuma) {
        muokattuTapahtuma.setTapahtuma_id(id);
        return tapahtumaRepository.save(muokattuTapahtuma);
    }

    // @DeleteMapping("/tapahtumat/{id}")
    // public void poistaTapahtuma(@PathVariable("id") Long id) {
    //     tapahtumaRepository.deleteById(id);
    // }
    @DeleteMapping("/tapahtumat/{id}")
    public ResponseEntity<Object> poistaTapahtuma(@PathVariable("id") Long id) {
        // tarkistetaan, löytyykö tietokannasta tietuetta pyydetyllä id:llä
        if (!tapahtumaRepository.existsById(id)) {
            // jos ei löydy, palautetaan koodi 404 - not found 
            return ResponseEntity.notFound().build();
        }
        // jos tietue löytyy, se poistetaan ja palautetaan koodi 200 - ok
        tapahtumaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
