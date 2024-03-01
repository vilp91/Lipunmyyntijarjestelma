package ohjelmistoprojekti1.a3004.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;


/* @RestController
public class RestKayttajaController {

    @Autowired
    private MyyntitapahtumaService myyntitapahtumaService;

    @GetMapping("/kayttajat/{kayttaja_id}/myyntitapahtumat")
    public ResponseEntity<List<Myyntitapahtuma>> getUserTransactions(@PathVariable("kayttaja_id") Long kayttaja_id) {
        List<Myyntitapahtuma> userTransactions = myyntitapahtumaService.getKayttajaTransactions(kayttaja_id);
        return ResponseEntity.ok(userTransactions);
    }
}
*/