package ohjelmistoprojekti1.a3004.web;

import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.KayttajaRepository;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;

@RestController
public class RestMyyntitapahtumaController {

    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    @Autowired
    private KayttajaRepository kayttajaRepository;

    @Autowired
    private Mapper mapper;

    private final KayttajaService kayttajaService;

    public RestMyyntitapahtumaController(KayttajaService kayttajaService) {
        this.kayttajaService = kayttajaService;
    }

    @GetMapping("/myyntitapahtumat")
    public Iterable<Myyntitapahtuma> haeMyyntitapahtumat() {
        return myyntitapahtumaRepository.findAll();
    }

    @GetMapping("/myyntitapahtumatDTO")
    public List<MyyntitapahtumaDTO> haeMyyntitapahtumatDTO() {
        Iterable<Myyntitapahtuma> myyntitapahtumat = myyntitapahtumaRepository.findAll();
        return StreamSupport.stream(myyntitapahtumat.spliterator(), false).map(mapper::toDTO).collect(toList());
    }


    @PostMapping("/myyntitapahtumaDTO")
    public ResponseEntity<MyyntitapahtumaLuontiDTO> luoMyyntitapahtuma(@RequestBody MyyntitapahtumaLuontiDTO myyntitapahtumaLuontiDTO) {
       Long kayttaja_id = myyntitapahtumaLuontiDTO.getKayttaja_id();
        Kayttaja kayttaja = kayttajaRepository.findById(kayttaja_id)
        .orElseThrow(() -> new RuntimeException("Kayttaja not found with id: " + kayttaja_id));
        MyyntitapahtumaLuontiDTO myyntitapahtuma = kayttajaService.luoMyyntitapahtuma(myyntitapahtumaLuontiDTO.getKayttaja_id(), myyntitapahtumaLuontiDTO.getLiput());        

        return new ResponseEntity<>(myyntitapahtuma, HttpStatus.CREATED);
    }

}
