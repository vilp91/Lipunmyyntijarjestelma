package ohjelmistoprojekti1.a3004.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;


public interface LippuRepository extends CrudRepository<Lippu, Long>{
    List<Lippu> findByMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma);
    List<Lippu> findByTapahtumanLipputyyppiIn(List<TapahtumanLipputyyppi> tapahtumanLipputyypit);
    List<Lippu> findByLippunumero(UUID lippunumero);
    Optional<Lippu> findByLippuIdAndPoistettuFalse(Long lippuId);
    List<Lippu> findByPoistettuFalse();
    boolean existsByLippunumeroAndPoistettuFalse(UUID lippunumero);
    boolean existsByLippuIdAndPoistettuFalse(Long LippuId);

}
