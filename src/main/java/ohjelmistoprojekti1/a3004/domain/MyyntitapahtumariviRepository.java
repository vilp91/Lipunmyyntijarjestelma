package ohjelmistoprojekti1.a3004.domain;

import org.springframework.data.repository.CrudRepository;

public interface MyyntitapahtumariviRepository extends CrudRepository<Myyntitapahtumarivi, Long> {
    // tässä luodaan normaali luokka, joka nimetään entity-luokka + Repository
    // muut muutokset voi tehdä manuaalisesti, eli
    // muuttaa: class -> interface
    // ja lisätä: extends CrudRepository<Entity-luokka, Entity-luokan primary key:n tietotyyppi>

}
