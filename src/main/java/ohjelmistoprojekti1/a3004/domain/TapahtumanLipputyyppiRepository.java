package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TapahtumanLipputyyppiRepository extends CrudRepository<TapahtumanLipputyyppi, Long> {

    List<TapahtumanLipputyyppi> findByTapahtuma(Tapahtuma tapahtuma);

    Boolean existsByLipputyyppi(Lipputyyppi lipputyyppi);
    /* 
    //Tämä on @PostMapping("/tapahtumanlipputyypit") yhtä error tarkistusta varten.
    //Voi ottaa käyttöön kun entityjen id:t on CamelCase.
    Boolean existsByLipputyyppiId(Boolean b);
     */
}
