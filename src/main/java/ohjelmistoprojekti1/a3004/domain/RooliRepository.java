package ohjelmistoprojekti1.a3004.domain;


import org.springframework.data.repository.CrudRepository;

public interface RooliRepository extends CrudRepository<Rooli, Long>{

   Rooli findByRooli(String rooli); 


}
