package ohjelmistoprojekti1.a3004.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;

/*   @Service
public class MyyntitapahtumaService {

    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    public List<Myyntitapahtuma> getAllMyyntitapahtumatWithLippuAndTapahtuma() {
        return myyntitapahtumaRepository.findAllWithLippuAndTapahtuma();
    }

    public Iterable<Myyntitapahtuma> getAllMyyntitapahtumat() {
        return myyntitapahtumaRepository.findAll();
    }

    public Myyntitapahtuma createMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma) {
        return myyntitapahtumaRepository.save(myyntitapahtuma);
    }

    private Kayttaja findKayttajaById(Long kayttaja_id) {
        return null;
    }

    public List<Myyntitapahtuma> getKayttajaTransactions(Long kayttaja_id) {
      
        Kayttaja kayttaja = findKayttajaById(kayttaja_id);
        
        if (kayttaja != null) {
            
            return myyntitapahtumaRepository.findByKayttaja(kayttaja);
        } else {
          
            return null; 
        }
    }
    
} */
