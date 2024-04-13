package ohjelmistoprojekti1.a3004.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long>{
    Optional<List<Tapahtuma>> findAllByAlkuAfter(LocalDateTime pvm);
    Optional<List<Tapahtuma>> findAllByAlkuAfterAndAlkuBefore(LocalDateTime alkaen, LocalDateTime paattyen);
    Tapahtuma findByTapahtumaId(Long id);
}
