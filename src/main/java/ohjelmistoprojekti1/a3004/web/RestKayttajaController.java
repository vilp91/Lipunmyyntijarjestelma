package ohjelmistoprojekti1.a3004.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.KayttajaRepository;
import ohjelmistoprojekti1.a3004.domain.Rooli;
import ohjelmistoprojekti1.a3004.domain.RooliRepository;

@RestController
public class RestKayttajaController {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    @Autowired
    private RooliRepository rooliRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/kayttajat")
    public Iterable<Kayttaja> haeKayttajat() {
        return kayttajaRepository.findByPoistettuFalse();
    }

    @Transactional
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/kayttajat")
    public ResponseEntity<?> lisaaKayttaja(@Valid @RequestBody Kayttaja kayttaja) {

        // tarkistetaan, ettei pyynnössä ole käyttäjäId:tä.
        if (kayttaja.getKayttajaId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Poista pyynnöstä kayttajaId");
        }

        // tarkistetaan puuttuuko roolista tietoja
        if (kayttaja.getRooli() == null || kayttaja.getRooli().getRooliId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RooliId puuttuu");
        }

        // tarkistetaan löytyykö annetulla rooliId:llä roolia
        Rooli existingRooli = rooliRepository.findByRooliIdAndPoistettuFalse(kayttaja.getRooli().getRooliId());
        if (existingRooli == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Roolia id:llä " + kayttaja.getRooli().getRooliId() + " ei löydy.");
        }

        try {
            // haetaan annetun rooliId:n perusteella koko Rooli ja asetetaan se käyttäjälle ennen tallentamista tietokantaan.
            Long rooliId = kayttaja.getRooli().getRooliId();
            Rooli rooli = rooliRepository.findById(rooliId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roolia id:llä " + kayttaja.getRooli().getRooliId() + " ei löydy."));
            kayttaja.setRooli(rooli);
            Kayttaja savedKayttaja = kayttajaRepository.save(kayttaja);

            // luodaan erillinen käyttäjä ilman käyttäjänimeä ja salasanaa response bodyyn
            Kayttaja responseKayttaja = new Kayttaja();
            responseKayttaja.setKayttajaId(savedKayttaja.getKayttajaId());
            responseKayttaja.setEtunimi(savedKayttaja.getEtunimi());
            responseKayttaja.setSukunimi(savedKayttaja.getSukunimi());
            responseKayttaja.setPuhnro(savedKayttaja.getPuhnro());
            responseKayttaja.setKatuosoite(savedKayttaja.getKatuosoite());
            responseKayttaja.setRooli(savedKayttaja.getRooli());
            responseKayttaja.setKayttajanimi(savedKayttaja.getKayttajanimi());

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedKayttaja.getKayttajaId())
                    .toUri();
            return ResponseEntity.created(location).body(responseKayttaja);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Käyttäjä käyttäjänimellä " + kayttaja.getKayttajanimi() + " on jo olemassa.");
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid input: " + e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/kayttajat/{id}")
    public ResponseEntity<?> muokkaaKayttaja(@PathVariable("id") Long id, @RequestBody Kayttaja muokattuKayttaja) {
        // tarkistetaan, että id:llä löytyy tietue
        Kayttaja kayttaja = kayttajaRepository.findById(id).orElse(null);
        if (kayttaja == null || kayttaja.isPoistettu()) {
            return ResponseEntity.notFound().build();
        }
        if (muokattuKayttaja.getRooli() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarkista rooli");
        }
        // jos roolia on muokattu, tarkistetaan, että uusi rooli on olemassa
        if (muokattuKayttaja.getRooli().getRooliId() != kayttaja.getRooli().getRooliId()) {
            if (!rooliRepository.existsByRooliIdAndPoistettuFalse(muokattuKayttaja.getRooli().getRooliId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarkista rooliId");
            } else {
                kayttaja.setRooli(rooliRepository.findById(muokattuKayttaja.getRooli().getRooliId()).get());
            }
        }
        // tarkistetaan, että pyynnössä on nimet
        if (muokattuKayttaja.getEtunimi() == null || muokattuKayttaja.getSukunimi() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarkista etu- ja sukunimi");
        }
        // päivitetään käyttäjä uusien tietojen mukaiseksi ja tallennetaan se
        kayttaja.setEtunimi(muokattuKayttaja.getEtunimi());
        kayttaja.setSukunimi(muokattuKayttaja.getSukunimi());
        kayttaja.setPuhnro(muokattuKayttaja.getPuhnro());
        kayttaja.setKatuosoite(muokattuKayttaja.getKatuosoite());

        kayttajaRepository.save(kayttaja);        
        return ResponseEntity.ok().body(kayttaja);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/kayttajat/{id}")
    public ResponseEntity<?> poistaKayttaja(@PathVariable("id") Long id) {
        // haetaan oikea käyttäjä
        Kayttaja kayttaja = kayttajaRepository.findById(id).orElse(null);
        // jos käyttäjä on jo poistettu, tai sitä ei ole olemassa, palautetaan 404 - not found
        if (kayttaja == null || kayttaja.isPoistettu()) {
            return ResponseEntity.notFound().build();
        }
        // muussa tapauksessa merkitään kayttaja poistetuksi ja palautetaan 204 - no content
        kayttaja.setPoistettu(true);
        kayttajaRepository.save(kayttaja);
        return ResponseEntity.noContent().build();
    }

}
