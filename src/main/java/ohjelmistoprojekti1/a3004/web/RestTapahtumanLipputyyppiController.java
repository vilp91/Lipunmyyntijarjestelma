package ohjelmistoprojekti1.a3004.web;

import java.net.URI;
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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import ohjelmistoprojekti1.a3004.domain.Lippu;
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

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/tapahtumanlipputyypit")
    public Iterable<TapahtumanLipputyyppi> haeTapahtumanLipputyypit() {
        return tapahtumanLipputyyppiRepository.findByPoistettuFalse();
    }

    @PreAuthorize("hasAuthority('ROLE_MYYJA') || hasAuthority('ROLE_ADMIN')")
    @GetMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> haeTapahtumanlipputyyppi(@PathVariable("id") Long id) {
        // tarkistetaan, onko tietokannassa pyyntöä vastaavaa tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsByTapahtumanLipputyyppiIdAndPoistettuFalse(id)) {
            // jos on, niin haetaan se ja muutetaan DTO-versioksi
            TapahtumanLipputyyppi tapahtumanLipputyyppi = tapahtumanLipputyyppiRepository.findById(id).get();
            TapahtumanlipputyyppiDTO tapahtumanlipputyyppiDTO = EntityToDTO(tapahtumanLipputyyppi);
            // palautetaan DTO-versio ja koodi 200
            return ResponseEntity.ok().body(tapahtumanlipputyyppiDTO);
        }
        // jos ei, palautetaan koodi 404
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumanlipputyyppiä ei löytynyt id:llä '" + id + "'.");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/tapahtumanlipputyypit")
    public ResponseEntity<?> luoTapahtumanLipputyyppi(
            @Valid @RequestBody TapahtumanlipputyyppiDTO tapahtumanLipputyyppiDto) {
        // tarkistetaan onko annetulla tapahtumaId:llä tapahtumaa tietokannassa
        if (!tapahtumaRepository.existsByTapahtumaIdAndPoistettuFalse(tapahtumanLipputyyppiDto.getTapahtuma())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tapahtumaa id:llä '" + tapahtumanLipputyyppiDto.getTapahtuma() + "' ei löydy.");
        }
        // tarkistetaan onko annetulla lipputyyppiID:llä lipputyyppiä tietokannassa
        if (!lipputyyppiRepository.existsByLipputyyppiIdAndPoistettuIsFalse(tapahtumanLipputyyppiDto.getLipputyyppiId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lipputyyppiä id:llä '" + tapahtumanLipputyyppiDto.getLipputyyppiId() + "' ei löydy");
        }

        // tarkistetaan onko annetulla lipputyyppiId:llä jo olemassa tapahtumanLipputyyppi samassa tapahtumassa
        if (tapahtumanLipputyyppiRepository.existsByLipputyyppiLipputyyppiId(tapahtumanLipputyyppiDto.getLipputyyppiId())) {
            List<TapahtumanLipputyyppi> tapahtumanLipputyyppiTapahtumaIdTest = tapahtumanLipputyyppiRepository.findByLipputyyppiLipputyyppiId(tapahtumanLipputyyppiDto.getLipputyyppiId());

            for (TapahtumanLipputyyppi tapahtumanLipputyyppiIdTest : tapahtumanLipputyyppiTapahtumaIdTest) {
                if (tapahtumanLipputyyppiIdTest.getTapahtuma().getTapahtumaId().equals(tapahtumanLipputyyppiDto.getTapahtuma()) &&
                    !tapahtumanLipputyyppiIdTest.isPoistettu()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "LipputyyppiId:llä '" + tapahtumanLipputyyppiDto.getLipputyyppiId() + "' on jo olemassa tapahtumanlipputyyppi");
                }
            }
        }
        // tarkistetaan onko hinta positiivinen
        if (tapahtumanLipputyyppiDto.getHinta() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hinnan pitää olla positiivinen");
        }
        // muunnetaan DTO tapahtumanlipputyypiksi ja tallennetaan se tietokantaan
        TapahtumanLipputyyppi tapahtumanLipputyyppi = DTOtoEntity(tapahtumanLipputyyppiDto);
        TapahtumanLipputyyppi tallennettuTapahtumanLipputyyppi = tapahtumanLipputyyppiRepository
                .save(tapahtumanLipputyyppi);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tallennettuTapahtumanLipputyyppi.getTapahtumanLipputyyppiId())
                .toUri();
        // palautetaan clientille vastauksena 201 - Created ja DTO-versio luodusta
        // tapahtumanlipputyypistä
        tapahtumanLipputyyppiDto = EntityToDTO(tallennettuTapahtumanLipputyyppi);
        return ResponseEntity.created(location).body(tapahtumanLipputyyppiDto);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> muokkaaTapahtumanlipputyyppi(@PathVariable("id") Long id,
            @Valid @RequestBody TapahtumanlipputyyppiDTO muokattuTapahtumanLipputyyppiDto) {
        // tarkistetaan, onko tietokannassa id:tä vastaava tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsByTapahtumanLipputyyppiIdAndPoistettuFalse(id)) {
            if (tapahtumaRepository.existsByTapahtumaIdAndPoistettuFalse(muokattuTapahtumanLipputyyppiDto.getTapahtuma())) {
                if (lipputyyppiRepository.existsByLipputyyppiIdAndPoistettuIsFalse(muokattuTapahtumanLipputyyppiDto.getLipputyyppiId())) {
                    // muunnetaan DTO tapahtumanlipputyypiksi, asetetaan sille oikea id ja
                    // tallennetaan se tietokantaan
                    TapahtumanLipputyyppi muokattuTapahtumanLipputyyppi = DTOtoEntity(muokattuTapahtumanLipputyyppiDto);
                    muokattuTapahtumanLipputyyppi.setTapahtumanLipputyyppiId(id);
                    tapahtumanLipputyyppiRepository.save(muokattuTapahtumanLipputyyppi);
                    // palautetaan clientille DTO-versio muokatusta tapahtumanlipputyypistä
                    muokattuTapahtumanLipputyyppiDto = EntityToDTO(muokattuTapahtumanLipputyyppi);
                    return ResponseEntity.ok().body(muokattuTapahtumanLipputyyppiDto);
                }
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lipputyyppiä id:llä '" + muokattuTapahtumanLipputyyppiDto.getLipputyyppiId() + "' ei löydy.");
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tapahtumaa id:llä '" + muokattuTapahtumanLipputyyppiDto.getTapahtuma() + "' ei löydy.");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumanlipputyyppiä id:llä '" + id + "' ei löydy.");

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/tapahtumanlipputyypit/{id}")
    public ResponseEntity<?> poistaTapahtumanlipputyyppi(@PathVariable("id") Long id) {
        // tarkistetaan, onko tietokannassa id:tä vastaava tapahtumanlipputyyppi
        if (tapahtumanLipputyyppiRepository.existsByTapahtumanLipputyyppiIdAndPoistettuFalse(id)) {
            // poistetaan tapahtumanlipputyyppi
            TapahtumanLipputyyppi tapahtumanLipputyyppi = tapahtumanLipputyyppiRepository.findById(id).get();
            if (tapahtumanLipputyyppi.getLiput().size() > 0) {
                List<Lippu> liput = tapahtumanLipputyyppi.getLiput();
                for(Lippu lippu : liput) {
                    if (!lippu.isPoistettu()) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tapahtumanlipputyyppiin '" + id + "' liittyy lippuja. Tapahtumanlipputyyppiä ei voida poistaa");
                    }
                }
            }
            tapahtumanLipputyyppi.setPoistettu(true);
            tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi);
            return ResponseEntity.noContent().build();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumanlipputyyppiä id:llä '" + id + "' ei löydy");
    }

    // muunnetaan DTO-versio entity-versioksi
    public TapahtumanLipputyyppi DTOtoEntity(TapahtumanlipputyyppiDTO tapahtumanLipputyyppiDto) {
        TapahtumanLipputyyppi tapahtumanLipputyyppi = new TapahtumanLipputyyppi();
        tapahtumanLipputyyppi.setTapahtuma(tapahtumaRepository.findById(tapahtumanLipputyyppiDto.getTapahtuma()).orElse(null));
        tapahtumanLipputyyppi.setHinta(tapahtumanLipputyyppiDto.getHinta());
        tapahtumanLipputyyppi.setLipputyyppi(lipputyyppiRepository.findById(tapahtumanLipputyyppiDto.getLipputyyppiId()).orElse(null));
        return tapahtumanLipputyyppi;
    }

    // muunnetaan entity-versio DTO-versioksi
    public TapahtumanlipputyyppiDTO EntityToDTO(TapahtumanLipputyyppi tapahtumanLipputyyppi) {
        TapahtumanlipputyyppiDTO tapahtumanlipputyyppiDTO = new TapahtumanlipputyyppiDTO();
        tapahtumanlipputyyppiDTO.setId(tapahtumanLipputyyppi.getTapahtumanLipputyyppiId());
        tapahtumanlipputyyppiDTO.setTapahtuma(tapahtumanLipputyyppi.getTapahtuma().getTapahtumaId());
        tapahtumanlipputyyppiDTO.setHinta(tapahtumanLipputyyppi.getHinta());
        tapahtumanlipputyyppiDTO.setLipputyyppiId(tapahtumanLipputyyppi.getLipputyyppi().getLipputyyppiId());
        tapahtumanlipputyyppiDTO.setLipputyyppi(tapahtumanLipputyyppi.getLipputyyppi().getTyyppi());
        return tapahtumanlipputyyppiDTO;

    }

}
