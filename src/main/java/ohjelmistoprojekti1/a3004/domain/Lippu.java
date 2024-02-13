package ohjelmistoprojekti1.a3004.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lippu")
public class Lippu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lippu_id;

    @ManyToOne
    @JoinColumn(name = "tapahtuman_lipputyyppi_id")
    private TapahtumanLipputyyppi tapahtuman_lipputyyppi;

    @ManyToOne
    @JoinColumn(name = "myyntitapahtuma_id")
    private Myyntitapahtuma myyntitapahtuma;

    private float hinta;

/*     @ManyToOne
    @JoinColumn(name = "lipputyyppi_id")
    private Lipputyyppi lipputyyppi; */

/*     @ManyToOne
    @JoinColumn(name = "tapahtuma_id")
    private Tapahtuma tapahtuma; */

    //Parametriton konstruktori
    public Lippu() {
    }

    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
    public Lippu(TapahtumanLipputyyppi tapahtuman_lipputyyppi, Myyntitapahtuma myyntitapahtuma, float hinta) {
        this.tapahtuman_lipputyyppi = tapahtuman_lipputyyppi;
        this.myyntitapahtuma = myyntitapahtuma;
        this.hinta = hinta;
    }
    //Getterit ja setterit
    public Long getLippu_id() {
        return lippu_id;
    }

    public void setLippu_id(Long lippu_id) {
        this.lippu_id = lippu_id;
    }

    public TapahtumanLipputyyppi getTapahtuman_lipputyyppi() {
        return tapahtuman_lipputyyppi;
    }

    public void setTapahtuman_lipputyyppi(TapahtumanLipputyyppi tapahtuman_lipputyyppi) {
        this.tapahtuman_lipputyyppi = tapahtuman_lipputyyppi;
    }

    public Myyntitapahtuma getMyyntitapahtuma() {
        return myyntitapahtuma;
    }

    public void setMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma) {
        this.myyntitapahtuma = myyntitapahtuma;
    }

    public float getHinta() {
        return hinta;
    }

    public void setHinta(float hinta) {
        this.hinta = hinta;
    }

    @Override
    public String toString() {
        return "Lippu [lippu_id=" + lippu_id + ", tapahtuman_lipputyyppi=" + tapahtuman_lipputyyppi
                + ", myyntitapahtuma=" + myyntitapahtuma + ", hinta=" + hinta + "]";
    }


}
