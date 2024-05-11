package ohjelmistoprojekti1.a3004.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface KayttajaRepository extends CrudRepository<Kayttaja, Long>{

    Kayttaja findByKayttajanimi(String kayttajanimi);
    List<Kayttaja> findByPoistettuFalse();
}
