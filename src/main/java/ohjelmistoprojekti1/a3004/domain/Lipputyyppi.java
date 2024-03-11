package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "lipputyyppi")
public class Lipputyyppi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lipputyyppi_id;

    @NotEmpty(message = "Lipputyypin tyyppi on pakollinen tieto")
    private String tyyppi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lipputyyppi")
    @JsonIgnore
    private List<TapahtumanLipputyyppi> tapahtuman_lipputyypit;

    //Parametriton konstruktori
    public Lipputyyppi() {
    }

    public Lipputyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
     public Lipputyyppi(String tyyppi, List<TapahtumanLipputyyppi> tapahtuman_lipputyypit) {
        super();
        this.tyyppi = tyyppi;
        this.tapahtuman_lipputyypit = tapahtuman_lipputyypit;
    }

    //Getterit ja setterit
    public Long getLipputyyppi_id() {
        return lipputyyppi_id;
    }

    public void setLipputyyppi_id(Long lipputyyppi_id) {
        this.lipputyyppi_id = lipputyyppi_id;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public List<TapahtumanLipputyyppi> getTapahtuman_lipputyypit() {
        return tapahtuman_lipputyypit;
    }

    public void setTapahtuman_lipputyypit(List<TapahtumanLipputyyppi> tapahtuman_lipputyypit) {
        this.tapahtuman_lipputyypit = tapahtuman_lipputyypit;
    }

    @Override
    public String toString() {
        return "Lipputyyppi [lipputyyppi_id=" + lipputyyppi_id + ", tyyppi=" + tyyppi + ", tapahtuman_lipputyypit="
                + tapahtuman_lipputyypit + "]";
    }


}
