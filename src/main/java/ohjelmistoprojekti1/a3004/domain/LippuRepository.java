package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;


public interface LippuRepository extends CrudRepository<Lippu, Long>{
    List<Lippu> findByMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma);
    List<Lippu> findByTapahtumanLipputyyppiIn(List<TapahtumanLipputyyppi> tapahtumanLipputyypit);
    List<Lippu> findByLippunumero(UUID lippunumero);
    boolean existsByLippunumero(UUID lippunumero);

}
