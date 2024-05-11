package ohjelmistoprojekti1.a3004.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
