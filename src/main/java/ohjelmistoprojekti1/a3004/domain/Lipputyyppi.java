package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lipputyyppi")
public class Lipputyyppi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lipputyyppi_id;

    private String tyyppi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lipputyyppi")
    private List<Alennus> alennus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lipputyyppi")
    private List<Lippu> lippu;

    //Parametriton konstruktori
    public Lipputyyppi() {
    }

    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
    public Lipputyyppi(String tyyppi) {
        super();
        this.tyyppi = tyyppi;
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

    public List<Alennus> getAlennus() {
        return alennus;
    }

    public void setAlennus(List<Alennus> alennus) {
        this.alennus = alennus;
    }

    public List<Lippu> getLippu() {
        return lippu;
    }

    public void setLippu(List<Lippu> lippu) {
        this.lippu = lippu;
    }

    @Override
    public String toString() {
        return "Lipputyyppi [lipputyyppi_id=" + lipputyyppi_id + ", tyyppi=" + tyyppi + "]";
    }

}
