package ohjelmistoprojekti1.a3004.domain;


import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface RooliRepository extends CrudRepository<Rooli, Long>{

   Rooli findByRooliAndPoistettuFalse(String rooli);
   Rooli findByRooliIdAndPoistettuFalse(Long rooliId);
   List<Rooli> findByPoistettuFalse();
   boolean existsByRooliIdAndPoistettuFalse(Long rooliId);


}
