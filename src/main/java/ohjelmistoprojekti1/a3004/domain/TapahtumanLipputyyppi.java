package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tapahtuman_lipputyyppi")
public class TapahtumanLipputyyppi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tapahtuman_lipputyyppi_id;
    private double hinta;

    @ManyToOne
    @JoinColumn(name = "tapahtuma_id")
    private Tapahtuma tapahtuma;

    @ManyToOne
    @JoinColumn(name = "lipputyyppi_id")
    private Lipputyyppi lipputyyppi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tapahtuman_lipputyyppi")
    @JsonIgnore
    private List<Lippu> liput;

    public TapahtumanLipputyyppi() {
        super();
    }
    
    public TapahtumanLipputyyppi(float hinta, Tapahtuma tapahtuma, Lipputyyppi lipputyyppi) {
        this.hinta = hinta;
        this.tapahtuma = tapahtuma;
        this.lipputyyppi = lipputyyppi;
    }

    public TapahtumanLipputyyppi(double hinta, Tapahtuma tapahtuma, Lipputyyppi lipputyyppi, List<Lippu> liput) {
        this.hinta = hinta;
        this.tapahtuma = tapahtuma;
        this.lipputyyppi = lipputyyppi;
        this.liput = liput;
    }

    public TapahtumanLipputyyppi(double hinta, Tapahtuma tapahtuma, Lipputyyppi lipputyyppi) {
        this.hinta = hinta;
        this.tapahtuma = tapahtuma;
        this.lipputyyppi = lipputyyppi;
        
    }

    public Long getTapahtuman_lipputyyppi_id() {
        return tapahtuman_lipputyyppi_id;
    }

    public void setTapahtuman_lipputyyppi_id(Long tapahtuman_lipputyyppi_id) {
        this.tapahtuman_lipputyyppi_id = tapahtuman_lipputyyppi_id;
    }

    public double getHinta() {
        return hinta;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    public Lipputyyppi getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(Lipputyyppi lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    public List<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }

    @Override
    public String toString() {
        return "TapahtumanLipputyyppi [tapahtuman_lipputyyppi_id=" + tapahtuman_lipputyyppi_id + ", hinta=" + hinta
                + ", tapahtuma=" + tapahtuma + ", lipputyyppi=" + lipputyyppi + ", liput=" + liput + "]";
    }
    
    
    
}
