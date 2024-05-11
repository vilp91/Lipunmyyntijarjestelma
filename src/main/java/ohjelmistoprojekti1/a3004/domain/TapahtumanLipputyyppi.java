package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tapahtumanLipputyyppi")
public class TapahtumanLipputyyppi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tapahtumanLipputyyppiId;
    
    @Positive
    private float hinta;

    @ManyToOne
    @JoinColumn(name = "tapahtumaId")
    private Tapahtuma tapahtuma;

    @ManyToOne
    @JoinColumn(name = "lipputyyppiId")
    private Lipputyyppi lipputyyppi;

    @OneToMany(mappedBy = "tapahtumanLipputyyppi")
    @JsonIgnore
    private List<Lippu> liput;

    @JsonIgnore
    private boolean poistettu = false;

    public TapahtumanLipputyyppi() {
        super();
    }
    
    public TapahtumanLipputyyppi(float hinta, Tapahtuma tapahtuma, Lipputyyppi lipputyyppi) {
        this.hinta = hinta;
        this.tapahtuma = tapahtuma;
        this.lipputyyppi = lipputyyppi;

    }

    public TapahtumanLipputyyppi(float hinta, Tapahtuma tapahtuma, Lipputyyppi lipputyyppi, List<Lippu> liput) {
        this.hinta = hinta;
        this.tapahtuma = tapahtuma;
        this.lipputyyppi = lipputyyppi;
        this.liput = liput;
        
    }

    public Long getTapahtumanLipputyyppiId() {
        return tapahtumanLipputyyppiId;
    }

    public void setTapahtumanLipputyyppiId(Long tapahtumanLipputyyppiId) {
        this.tapahtumanLipputyyppiId = tapahtumanLipputyyppiId;
    }

    public float getHinta() {
        return hinta;
    }

    public void setHinta(float hinta) {
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

    public boolean isPoistettu() {
        return poistettu;
    }

    public void setPoistettu(boolean poistettu) {
        this.poistettu = poistettu;
    }


    @Override
    public String toString() {
        return "TapahtumanLipputyyppi [tapahtumanLipputyyppiId=" + tapahtumanLipputyyppiId + ", hinta=" + hinta
                + ", tapahtuma=" + tapahtuma + ", lipputyyppi=" + lipputyyppi + ", liput=" + liput + ", poistettu="
                + poistettu + "]";
    }
   
    
}
