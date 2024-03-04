package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    // pitäisi varmaan lisätä Get-metodi tietyn tapahtuman lipputyypeille..?

    @PostMapping("/tapahtumanlipputyypit")
    public ResponseEntity<?> luoTapahtumanLipputyyppi(@RequestBody TapahtumanlipputyyppiDTO tapahtumanLipputyyppiDto) {
        // tarkistetaan, onko tietokannassa pyyntöä vastaava tapahtuma
        if (tapahtumaRepository.existsById(tapahtumanLipputyyppiDto.getTapahtuma())) {
            //tarkistetaan, onko tietokannassa pyyntöä vastaava lipputyyppi
            if (lipputyyppiRepository.existsById(tapahtumanLipputyyppiDto.getLipputyyppi())) {
                // muunnetaan DTO tapahtumanlipputyypiksi ja tallennetaan se tietokantaan
                TapahtumanLipputyyppi tapahtumanLipputyyppi = DTOtoEntity(tapahtumanLipputyyppiDto);
                tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi);
                // palautetaan clientille vastauksena DTO-versio luodusta tapahtumanlipputyypistä
                return ResponseEntity.ok(tapahtumanLipputyyppiDto);     
            }
            return ResponseEntity.badRequest().body("Lipputyyppiä ei ole olemassa");
        }
        return ResponseEntity.badRequest().body("Tapahtumaa ei ole olemassa"); 
    }

    @PutMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> muokkaaTapahtumanlipputyyppi(@PathVariable("id") Long id, @RequestBody TapahtumanlipputyyppiDTO muokattuTapahtumanLipputyyppiDto) {
        // tarkistetaan, onko tietokannassa id:tä vastaava tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsById(id)) {
            // muunnetaan DTO tapahtumanlipputyypiksi, asetetaan sille oikea id ja tallennetaan se tietokantaan
            TapahtumanLipputyyppi muokattuTapahtumanLipputyyppi = DTOtoEntity(muokattuTapahtumanLipputyyppiDto);
            muokattuTapahtumanLipputyyppi.setTapahtuman_lipputyyppi_id(id);
            tapahtumanLipputyyppiRepository.save(muokattuTapahtumanLipputyyppi);
            // palautetaan clientille DTO-versio muokatusta tapahtumanlipputyypistä
            return ResponseEntity.ok().body(muokattuTapahtumanLipputyyppiDto); 
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> poistaTapahtumanlipputyyppi(@PathVariable("id") Long id) {
        // tarkistetaan, onko tietokannassa id:tä vastaava tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsById(id)) {
            // poistetaan tapahtumanlipputyyppi
            tapahtumanLipputyyppiRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    // muunnetaan DTO-versio entity-versioksi
    private TapahtumanLipputyyppi DTOtoEntity(TapahtumanlipputyyppiDTO tapahtumanLipputyyppiDto) {
        TapahtumanLipputyyppi tapahtumanLipputyyppi = new TapahtumanLipputyyppi();
        tapahtumanLipputyyppi.setTapahtuma(tapahtumaRepository.findById(tapahtumanLipputyyppiDto.getTapahtuma()).orElse(null));
        tapahtumanLipputyyppi.setHinta(tapahtumanLipputyyppiDto.getHinta());
        tapahtumanLipputyyppi.setLipputyyppi(lipputyyppiRepository.findById(tapahtumanLipputyyppiDto.getLipputyyppi()).orElse(null));
        return tapahtumanLipputyyppi;
    }
    
}
