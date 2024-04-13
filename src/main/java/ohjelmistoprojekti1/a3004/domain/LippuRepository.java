package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LippuRepository extends CrudRepository<Lippu, Long>{
    List<Lippu> findByMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma);
    List<Lippu> findByTapahtumanLipputyyppiIn(List<TapahtumanLipputyyppi> tapahtumanLipputyypit);


}
