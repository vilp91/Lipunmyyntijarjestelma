package ohjelmistoprojekti1.a3004.domain;

import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long>{

    Kayttaja findByKayttajatunnus(String username);
    


}
