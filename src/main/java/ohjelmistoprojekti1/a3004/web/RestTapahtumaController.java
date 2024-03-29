package ohjelmistoprojekti1.a3004.web;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private RestTapahtumanLipputyyppiController tapahtumanLipputyyppiController;

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

    @GetMapping("/tapahtumat/{id}")
    public ResponseEntity<?> haeTapahtuma(@PathVariable("id") Long id) {
        // tarkistaa, että tietokannassa on tietue annetulla id:llä
        // jos ei, niin palauttaa koodin 404
        if (!tapahtumaRepository.existsById(id)) {
            String errorMessage = "Tapahtumaa syötetyllä id:llä: " + id + ", ei löydy :(";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        // hakee tapahtuman tiedot
        Tapahtuma tapahtuma = tapahtumaRepository.findById(id).orElse(null);

        // luo uuden DTO-version
        TapahtumaDTO tapahtumaDTO = EntityToDTO(tapahtuma);
        tapahtumaDTO.setTapahtuma_id(id);
        return ResponseEntity.ok().body(tapahtumaDTO);
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
        tapahtumaDTO.setMyydyt_liput_lukum(tapahtuma.getMyydyt_liput_lukum());
        List<TapahtumanLipputyyppi> tapahtumanLipputyypit = tapahtumanLipputyyppiRepository.findByTapahtuma(tapahtuma);
        List<TapahtumanlipputyyppiDTO> tapahtumanlipputyyppiDTOt = new ArrayList<>();
        for (TapahtumanLipputyyppi tapahtumanLipputyyppi : tapahtumanLipputyypit) {
            TapahtumanlipputyyppiDTO tapahtumanlipputyyppiDTO = tapahtumanLipputyyppiController.EntityToDTO(tapahtumanLipputyyppi);
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

    // haetaan yhteen tapahtumaan liittyvät tapahtumanlipputyypit
    @GetMapping("/tapahtumat/{id}/tapahtumanlipputyypit")
    public ResponseEntity<?> haeTapahtumakohtaisetTapahtumanlipputyypit(@PathVariable("id") Long id) {
        // tarkistetaan, että tapahtuma on olemassa
        if (!tapahtumaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        // haetaan tapahtumanlipputyypit ja muutetaan ne DTO-versioiksi
        List<TapahtumanLipputyyppi> tapahtumanlipputyypit = tapahtumaRepository.findById(id).orElse(null).getTapahtuman_lipputyypit();
        List<TapahtumanlipputyyppiDTO> tapahtumanlipputyyppiDTOt = new ArrayList<>();
        
        for (TapahtumanLipputyyppi tapahtumanlipputyyppi : tapahtumanlipputyypit) {
            TapahtumanlipputyyppiDTO tapahtumanlipputyyppiDTO = tapahtumanLipputyyppiController.EntityToDTO(tapahtumanlipputyyppi);
            tapahtumanlipputyyppiDTOt.add(tapahtumanlipputyyppiDTO);
        }
        return ResponseEntity.ok(tapahtumanlipputyyppiDTOt);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/tapahtumat/{id}")
    public ResponseEntity<?> muokattuTapahtuma(@PathVariable("id") Long id, @Valid @RequestBody Tapahtuma muokattuTapahtuma) {
        if (tapahtumaRepository.existsById(id)) {
            muokattuTapahtuma.setTapahtuma_id(id);
            tapahtumaRepository.save(muokattuTapahtuma);
            return ResponseEntity.ok().body(muokattuTapahtuma);
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/tapahtumat/{id}")
    public ResponseEntity<Object> poistaTapahtuma(@PathVariable("id") Long id) {
        // tarkistetaan, löytyykö tietokannasta tietuetta pyydetyllä id:llä
        if (!tapahtumaRepository.existsById(id)) {
            // jos ei löydy, palautetaan koodi 404 - not found 
            return ResponseEntity.notFound().build();
        }
        // jos tietue löytyy, tarkistetaan liittyykö siihen myytyjä lippuja
        if ((tapahtumaRepository.findById(id).orElse(null).getMyydyt_liput_lukum()) != 0) {
            // jos löytyy, tietuetta ei voida poistaa
            return ResponseEntity.badRequest().build();
        }
        tapahtumaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
