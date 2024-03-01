package ohjelmistoprojekti1.a3004.web;

import java.util.List;



import org.springframework.stereotype.Service;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.KayttajaRepository;
import ohjelmistoprojekti1.a3004.domain.Lippu;

@Service
public class KayttajaService {

    private final KayttajaRepository kayttajaRepository;

    public KayttajaService(KayttajaRepository kayttajaRepository) {
        this.kayttajaRepository = kayttajaRepository;
    }

    public MyyntitapahtumaLuontiDTO luoMyyntitapahtuma(Long kayttaja_id, List<Lippu> liput) {
        // Load the Kayttaja from the repository
        Kayttaja kayttaja = kayttajaRepository.findById(kayttaja_id)
                .orElseThrow(() -> new RuntimeException("Kayttaja not found with ID: " + kayttaja_id));

        // Create MyyntitapahtumaLuontiDTO with the loaded Kayttaja
        MyyntitapahtumaLuontiDTO myyntitapahtuma = new MyyntitapahtumaLuontiDTO(kayttaja, liput);

        return myyntitapahtuma;
    }

}
