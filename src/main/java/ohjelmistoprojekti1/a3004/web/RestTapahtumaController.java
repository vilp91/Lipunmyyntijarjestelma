package ohjelmistoprojekti1.a3004.web;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import ohjelmistoprojekti1.a3004.domain.Tapahtuma;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppi;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppiRepository;

@RestController
public class RestTapahtumaController {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @Autowired
    private TapahtumanLipputyyppiRepository tapahtumanLipputyyppiRepository;

    @Autowired
    private RestTapahtumanLipputyyppiController restTapahtumanLipputyyppiController;

    // @GetMapping("/tapahtumat")
    // public Iterable<Tapahtuma> haeTapahtumat() {
    //     return tapahtumaRepository.findAll();
    // }

    @GetMapping("/tapahtumat")
    public List<TapahtumaDTO> haeTapahtumat() {
        Iterable<Tapahtuma> tapahtumat = tapahtumaRepository.findAll();
        List<TapahtumaDTO> tapahtumaDTOt = new ArrayList<>();

        for (Tapahtuma tapahtuma : tapahtumat) {
            TapahtumaDTO tapahtumaDTO = EntityToDTO(tapahtuma);
            tapahtumaDTOt.add(tapahtumaDTO);
        }
        return tapahtumaDTOt;
    }

    private TapahtumaDTO EntityToDTO(Tapahtuma tapahtuma) {
        TapahtumaDTO tapahtumaDTO = new TapahtumaDTO();
        tapahtumaDTO.setTapahtuma_id(tapahtuma.getTapahtuma_id());
        tapahtumaDTO.setTapahtuman_nimi(tapahtuma.getTapahtuman_nimi());
        tapahtumaDTO.setPaikka(tapahtuma.getPaikka());
        tapahtumaDTO.setKatuosoite(tapahtuma.getKatuosoite());
        tapahtumaDTO.setAlku(tapahtuma.getAlku());
        tapahtumaDTO.setLoppu(tapahtuma.getLoppu());
        tapahtumaDTO.setLippu_lukum(tapahtuma.getLippu_lukum());
        List<TapahtumanLipputyyppi> tapahtumanLipputyypit = tapahtumanLipputyyppiRepository.findByTapahtuma(tapahtuma);
        List<TapahtumanlipputyyppiDTO> tapahtumanlipputyyppiDTOt = new ArrayList<>();
        for (TapahtumanLipputyyppi tapahtumanLipputyyppi: tapahtumanLipputyypit) {
            TapahtumanlipputyyppiDTO tapahtumanlipputyyppiDTO = restTapahtumanLipputyyppiController.EntityToDTO(tapahtumanLipputyyppi);
            tapahtumanlipputyyppiDTOt.add(tapahtumanlipputyyppiDTO);
        }
        tapahtumaDTO.setTapahtuman_lipputyypit(tapahtumanlipputyyppiDTOt);
        return tapahtumaDTO;
    }

    // haetaan tapahtumat, joiden alku on kuluvan vuorokauden jälkeen
    @GetMapping("/tapahtumat/tulevat")
    public Iterable<Tapahtuma> tulevatTapahtumat() {
        // haetaan vertailuajaksi kuluvan vuorokauden viimeinen hetki
        LocalDateTime tanaan = LocalDateTime.now().with(LocalTime.MAX);
        return tapahtumaRepository.findAllByAlkuAfter(tanaan);
    }

    @PostMapping("/tapahtumat")
    public ResponseEntity<?> uusiTapahtuma(@Valid @RequestBody Tapahtuma uusiTapahtuma) {
        // tarkistetaan onko pyynnön rungossa annettu tapahtuma_id
        if (uusiTapahtuma.getTapahtuma_id() != null) {
            return ResponseEntity.badRequest().body("Poista pyynnöstä tapahtuma id");
        }
        // jos tapahtuma luodaan onnistuneesti, palautetaan 201 - Created ja luodun tapahtuman tiedot.
        Tapahtuma tallennettuTapahtuma = tapahtumaRepository.save(uusiTapahtuma);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(tallennettuTapahtuma.getTapahtuma_id())
            .toUri();
        return ResponseEntity.created(location).body(tallennettuTapahtuma);
    }

    @PutMapping("/tapahtumat/{id}")
    Tapahtuma muokattuTapahtuma(@PathVariable("id") Long id, @RequestBody Tapahtuma muokattuTapahtuma) {
        muokattuTapahtuma.setTapahtuma_id(id);
        return tapahtumaRepository.save(muokattuTapahtuma);
    }

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
