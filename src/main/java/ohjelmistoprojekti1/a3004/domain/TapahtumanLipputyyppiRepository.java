package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TapahtumanLipputyyppiRepository extends CrudRepository<TapahtumanLipputyyppi, Long> {

    List<TapahtumanLipputyyppi> findByTapahtuma(Tapahtuma tapahtuma);

    Boolean existsByLipputyyppi(Lipputyyppi lipputyyppi);

    //Nämä on @PostMapping("/tapahtumanlipputyypit") yhtä error tarkistusta varten.
    Boolean existsByLipputyyppiLipputyyppiId(Long lipputyyppiId);
    List<TapahtumanLipputyyppi> findByLipputyyppiLipputyyppiId(Long lipputyyppiId);

}
