package ohjelmistoprojekti1.a3004.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface LipputyyppiRepository extends CrudRepository<Lipputyyppi, Long>{
    Lipputyyppi findByTyyppi(String tyyppi);
    List<Lipputyyppi> findByPoistettuFalse();
    Lipputyyppi findByTyyppiAndPoistettuFalse(String tyyppi);
    boolean existsByLipputyyppiIdAndPoistettuIsFalse(Long lipputyyppiId);
}
