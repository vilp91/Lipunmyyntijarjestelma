package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TapahtumanLipputyyppiRepository extends CrudRepository<TapahtumanLipputyyppi, Long> {
    List<TapahtumanLipputyyppi> findByTapahtuma(Tapahtuma tapahtuma);
    
}
