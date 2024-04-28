package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface MyyntitapahtumaRepository extends CrudRepository<Myyntitapahtuma, Long> {

    List<Myyntitapahtuma>findByLiputIn(List<Lippu> lippuList);
    List<Myyntitapahtuma> findByPoistettuFalse();
    boolean existsByMyyntitapahtumaIdAndPoistettuFalse(Long myyntitapahtumaId);
}