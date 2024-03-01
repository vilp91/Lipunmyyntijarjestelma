package ohjelmistoprojekti1.a3004.web;

import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;

@RestController
public class RestMyyntitapahtumaController {

    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    @Autowired
    private Mapper mapper;

    @GetMapping("/myyntitapahtumat")
    public Iterable<Myyntitapahtuma> haeMyyntitapahtumat() {
        return myyntitapahtumaRepository.findAll();
    }

    @GetMapping("/myyntitapahtumatDTO")
    public List<MyyntitapahtumaDTO> haeMyyntitapahtumatDTO() {
        Iterable<Myyntitapahtuma> myyntitapahtumat = myyntitapahtumaRepository.findAll();
        return StreamSupport.stream(myyntitapahtumat.spliterator(), false).map(mapper::toDTO).collect(toList());
    }

    /* EI TOIMI
    @PostMapping("/myyntitapahtumaDTO")
    public ResponseEntity<Myyntitapahtuma> luoMyyntitapahtuma(@RequestBody MyyntitapahtumaLuontiDTO myyntitapahtumaLuontiDTO) {
        Myyntitapahtuma myyntitapahtuma = mapper.toMyyntitapahtuma(myyntitapahtumaLuontiDTO);        
        //Tähän lippujen lisäys?
        myyntitapahtumaRepository.save(myyntitapahtuma);
        return ResponseEntity.ok(myyntitapahtuma);
    }
     */
}
