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
    private Long lipputyyppiId;

    @NotEmpty(message = "Lipputyypin tyyppi on pakollinen tieto")
    private String tyyppi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lipputyyppi")
    @JsonIgnore
    private List<TapahtumanLipputyyppi> tapahtumanLipputyypit;

    @JsonIgnore
    private boolean poistettu = false;

    //Parametriton konstruktori
    public Lipputyyppi() {
    }

    public Lipputyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
     public Lipputyyppi(String tyyppi, List<TapahtumanLipputyyppi> tapahtumanLipputyypit) {
        super();
        this.tyyppi = tyyppi;
        this.tapahtumanLipputyypit = tapahtumanLipputyypit;
    }

    //Getterit ja setterit
    public Long getLipputyyppiId() {
        return lipputyyppiId;
    }

    public void setLipputyyppiId(Long lipputyyppiId) {
        this.lipputyyppiId = lipputyyppiId;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public List<TapahtumanLipputyyppi> getTapahtumanLipputyypit() {
        return tapahtumanLipputyypit;
    }

    public void setTapahtumanLipputyypit(List<TapahtumanLipputyyppi> tapahtumanLipputyypit) {
        this.tapahtumanLipputyypit = tapahtumanLipputyypit;
    }

    public boolean isPoistettu() {
        return poistettu;
    }

    public void setPoistettu(boolean poistettu) {
        this.poistettu = poistettu;
    }

    @Override
    public String toString() {
        return "Lipputyyppi [lipputyyppiId=" + lipputyyppiId + ", tyyppi=" + tyyppi + ", tapahtumanLipputyypit="
                + tapahtumanLipputyypit + ", poistettu=" + poistettu + "]";
    }  

}
