package ohjelmistoprojekti1.a3004.web;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa syötetyllä id:llä '" + id + "'', ei löydy :(");
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
        Optional<List<Tapahtuma>> optionalTapahtumat = Optional.ofNullable(tapahtumaRepository.findAllByAlkuAfter(tanaan).orElse(null));
        // jos tulevia tapahtumia on, ne palautetaan vastauksessa
        if (optionalTapahtumat.isPresent() && !optionalTapahtumat.get().isEmpty()) {
            return tapahtumaRepository.findAllByAlkuAfter(tanaan).get();
        }
        // jos tulevia tapahtumia ei ole, palautetaan seuraava
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ei tulevia tapahtumia");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/tapahtumat")
    public ResponseEntity<?> uusiTapahtuma(@Valid @RequestBody Tapahtuma uusiTapahtuma) {
        // tarkistetaan onko pyynnön rungossa annettu tapahtuma_id
        if (uusiTapahtuma.getTapahtuma_id() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Poista pyynnöstä tapahtuma_id");
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
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa id:llä '" + id + "', ei löydy");

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/tapahtumat/{id}")
    public ResponseEntity<Object> poistaTapahtuma(@PathVariable("id") Long id) {
        // tarkistetaan, löytyykö tietokannasta tietuetta pyydetyllä id:llä
        if (!tapahtumaRepository.existsById(id)) {
            // jos ei löydy, palautetaan koodi 404 - not found 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa id:llä '" + id + "', ei löydy");
        }
        // jos tietue löytyy, tarkistetaan liittyykö siihen myytyjä lippuja
        if ((tapahtumaRepository.findById(id).orElse(null).getMyydyt_liput_lukum()) != 0) {
            // jos löytyy, tietuetta ei voida poistaa
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tapahtumalla on myytyjä lippuja, tapahtumaa ei voi poistaa.");
        }
        tapahtumaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
