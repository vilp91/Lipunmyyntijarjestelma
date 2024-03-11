package ohjelmistoprojekti1.a3004.web;

import java.net.URI;

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
import ohjelmistoprojekti1.a3004.domain.LipputyyppiRepository;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppi;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppiRepository;

@RestController
public class RestTapahtumanLipputyyppiController {

    @Autowired
    private LipputyyppiRepository lipputyyppiRepository;
    @Autowired
    private TapahtumanLipputyyppiRepository tapahtumanLipputyyppiRepository;
    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @GetMapping("/tapahtumanlipputyypit")
    public Iterable<TapahtumanLipputyyppi> haeTapahtumanLipputyypit() {
        return tapahtumanLipputyyppiRepository.findAll();
    }

    @GetMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> haeTapahtumanlipputyyppi(@PathVariable("id") Long id) {
        // tarkistetaan, onko tietokannassa pyyntöä vastaavaa tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsById(id)) {
            // jos on, niin haetaan se ja muutetaan DTO-versioksi
            TapahtumanLipputyyppi tapahtumanLipputyyppi = tapahtumanLipputyyppiRepository.findById(id).orElse(null);
            TapahtumanlipputyyppiDTO tapahtumanlipputyyppiDTO = EntityToDTO(tapahtumanLipputyyppi);
            // palautetaan DTO-versio ja koodi 200
            return ResponseEntity.ok().body(tapahtumanlipputyyppiDTO);
        }
        // jos ei, palautetaan koodi 404
        return ResponseEntity.notFound().build();
    }

    // pitäisi varmaan lisätä Get-metodi tietyn tapahtuman lipputyypeille..?
    @PostMapping("/tapahtumanlipputyypit")
    public ResponseEntity<?> luoTapahtumanLipputyyppi(
            @Valid @RequestBody TapahtumanlipputyyppiDTO tapahtumanLipputyyppiDto) {
        // tarkistetaan, onko tietokannassa pyyntöä vastaava tapahtuma
        if (tapahtumanLipputyyppiDto.getHinta() > 0) {

            if (tapahtumaRepository.existsById(tapahtumanLipputyyppiDto.getTapahtuma())) {
                // tarkistetaan, onko tietokannassa pyyntöä vastaava lipputyyppi
                if (lipputyyppiRepository.existsById(tapahtumanLipputyyppiDto.getLipputyyppi())) {
                    // muunnetaan DTO tapahtumanlipputyypiksi ja tallennetaan se tietokantaan
                    TapahtumanLipputyyppi tapahtumanLipputyyppi = DTOtoEntity(tapahtumanLipputyyppiDto);
                    TapahtumanLipputyyppi tallennettuTapahtumanLipputyyppi = tapahtumanLipputyyppiRepository
                            .save(tapahtumanLipputyyppi);
                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(tallennettuTapahtumanLipputyyppi.getTapahtuman_lipputyyppi_id())
                            .toUri();
                    // palautetaan clientille vastauksena 201 - Created ja DTO-versio luodusta
                    // tapahtumanlipputyypistä
                    return ResponseEntity.created(location).body(tapahtumanLipputyyppiDto);
                }
                return ResponseEntity.badRequest().body("Lipputyyppiä ei ole olemassa");
            }
            return ResponseEntity.badRequest().body("Tapahtumaa ei ole olemassa");
        }
        return ResponseEntity.badRequest().body("Hinnan pitää olla positiivinen arvo");
    }

    @PutMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> muokkaaTapahtumanlipputyyppi(@PathVariable("id") Long id,
            @RequestBody TapahtumanlipputyyppiDTO muokattuTapahtumanLipputyyppiDto) {
        // tarkistetaan, onko tietokannassa id:tä vastaava tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsById(id)) {
            if (tapahtumaRepository.existsById(muokattuTapahtumanLipputyyppiDto.getTapahtuma())) {
                if (lipputyyppiRepository.existsById(muokattuTapahtumanLipputyyppiDto.getLipputyyppi())) {
                    // muunnetaan DTO tapahtumanlipputyypiksi, asetetaan sille oikea id ja
                    // tallennetaan se tietokantaan
                    TapahtumanLipputyyppi muokattuTapahtumanLipputyyppi = DTOtoEntity(muokattuTapahtumanLipputyyppiDto);
                    muokattuTapahtumanLipputyyppi.setTapahtuman_lipputyyppi_id(id);
                    tapahtumanLipputyyppiRepository.save(muokattuTapahtumanLipputyyppi);
                    // palautetaan clientille DTO-versio muokatusta tapahtumanlipputyypistä
                    return ResponseEntity.ok().body(muokattuTapahtumanLipputyyppiDto);
                }
                return ResponseEntity.badRequest().body("Lipputyyppiä ei ole olemassa");
            }
            return ResponseEntity.badRequest().body("Tapahtumaa ei ole olemassa");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> poistaTapahtumanlipputyyppi(@PathVariable("id") Long id) {
        // tarkistetaan, onko tietokannassa id:tä vastaava tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsById(id)) {
            // poistetaan tapahtumanlipputyyppi
            tapahtumanLipputyyppiRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // muunnetaan DTO-versio entity-versioksi
    public TapahtumanLipputyyppi DTOtoEntity(TapahtumanlipputyyppiDTO tapahtumanLipputyyppiDto) {
        TapahtumanLipputyyppi tapahtumanLipputyyppi = new TapahtumanLipputyyppi();
        tapahtumanLipputyyppi
                .setTapahtuma(tapahtumaRepository.findById(tapahtumanLipputyyppiDto.getTapahtuma()).orElse(null));
        tapahtumanLipputyyppi.setHinta(tapahtumanLipputyyppiDto.getHinta());
        tapahtumanLipputyyppi
                .setLipputyyppi(lipputyyppiRepository.findById(tapahtumanLipputyyppiDto.getLipputyyppi()).orElse(null));
        return tapahtumanLipputyyppi;
    }

    // muunnetaan entity-versio DTO-versioksi
    public TapahtumanlipputyyppiDTO EntityToDTO(TapahtumanLipputyyppi tapahtumanLipputyyppi) {
        TapahtumanlipputyyppiDTO tapahtumanlipputyyppiDTO = new TapahtumanlipputyyppiDTO();
        tapahtumanlipputyyppiDTO.setTapahtuma(tapahtumanLipputyyppi.getTapahtuma().getTapahtuma_id());
        tapahtumanlipputyyppiDTO.setHinta(tapahtumanLipputyyppi.getHinta());
        tapahtumanlipputyyppiDTO.setLipputyyppi(tapahtumanLipputyyppi.getTapahtuman_lipputyyppi_id());
        return tapahtumanlipputyyppiDTO;

    }

}
