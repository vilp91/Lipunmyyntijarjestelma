package ohjelmistoprojekti1.a3004.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;

@RestController
public class RestMyyntitapahtumaController {
    
    @Autowired
    MyyntitapahtumaRepository myyntitapahtumaRepository;
    @Autowired
    LippuRepository lippuRepository;

    @GetMapping("/myyntitapahtumat")
    public Iterable<Myyntitapahtuma> haeMyyntitapahtumat() {
        return myyntitapahtumaRepository.findAll();
    }

    // keskeneräinen, ei hae vielä kaikkea tietoa lipuista
    @GetMapping("/myyntitapahtumat/{id}")
    public MyyntitapahtumaDTO haeMyyntitapahtuma(@PathVariable("id") Long id) {
        // hakee myyntitapahtuman tiedot
        Myyntitapahtuma myyntitapahtuma = myyntitapahtumaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Myyntitapahtuma not found with id " + id));
        // luo uuden DTO-version ja lisää siihen id:n ja aikaleiman
        MyyntitapahtumaDTO myyntitapahtumaDTO = new MyyntitapahtumaDTO();
        myyntitapahtumaDTO.setId(id);
        myyntitapahtumaDTO.setAika(myyntitapahtuma.getAikaleima());
        // hakee tietokannasta myyntitapahtumaan liittyvät liput
        List<Lippu> liput = lippuRepository.findByMyyntitapahtuma(myyntitapahtuma);
        // luo listan lippujen DTO-versioille
        List<LippuDTO> lippuDTOLista = new ArrayList<>();
        // lisää listaan lippujen DTO-versiot (tosin vajailla tiedoilla..)
        for (Lippu lippu : liput) {
            LippuDTO lippuDTO = new LippuDTO();
            lippuDTO.setId(lippu.getLippu_id());
            lippuDTOLista.add(lippuDTO);
        }
        // asettaa listan myyntitapahtuman DTO-versioon
        myyntitapahtumaDTO.setLiput(lippuDTOLista);
        return myyntitapahtumaDTO;
    }
}
