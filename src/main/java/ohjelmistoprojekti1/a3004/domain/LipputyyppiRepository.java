package ohjelmistoprojekti1.a3004.domain;

import org.springframework.data.repository.CrudRepository;

public interface LipputyyppiRepository extends CrudRepository<Lipputyyppi, Long>{
    Lipputyyppi findByTyyppi(String tyyppi);

}
