package ohjelmistoprojekti1.a3004.web;

import java.net.URI;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import ohjelmistoprojekti1.a3004.domain.Rooli;
import ohjelmistoprojekti1.a3004.domain.RooliRepository;

@RestController
public class RestRooliController {

    @Autowired
    private RooliRepository rooliRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/roolit")
    public Iterable<Rooli> haeRoolit() {
        return rooliRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/roolit")
    public ResponseEntity<?> luoRooli(@Valid @RequestBody Rooli rooli) {
        // tarkistetaan, ettei pyynnössä ole rooliId.
        if (rooli.getRooliId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Poista pyynnöstä rooliId");
        }

        // tarkistetaan roolin muoto vastaamaan "ROLE_" + isoja kirjaimia.
        String rooliPattern = "^ROLE_[A-Z]+$";
        Pattern pattern = Pattern.compile(rooliPattern);
        if (!pattern.matcher(rooli.getRooli()).matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Roolin kirjoitusasu on väärä. Roolin tulee alkaa 'ROLE_', jonka jälkeen käytetään isoja kirjaimia.");
        }

        // tarkistetaan onko syötetyllä roolin nimellä jo olemassa rooli.
        Rooli existingRooliName = rooliRepository.findByRooli(rooli.getRooli());
        if (existingRooliName != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Rooli nimellä '" + rooli.getRooli() + "' on jo olemassa.");
        }

        try {
            Rooli savedRooli = rooliRepository.save(rooli);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedRooli.getRooliId())
                    .toUri();
            return ResponseEntity.created(location).body(savedRooli);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while creating the role: " + e.getMessage());
        }
    }

}
