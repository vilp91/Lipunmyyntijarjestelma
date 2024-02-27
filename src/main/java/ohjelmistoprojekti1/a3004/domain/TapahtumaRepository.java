package ohjelmistoprojekti1.a3004.domain;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long>{
    List<Tapahtuma> findAllByAlkuAfter(LocalDateTime pvm);
}
