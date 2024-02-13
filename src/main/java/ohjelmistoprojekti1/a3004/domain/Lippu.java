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
    private int hinta;

    @ManyToOne
    @JoinColumn(name = "lipputyyppi_id")
    private Lipputyyppi lipputyyppi;

    @ManyToOne
    @JoinColumn(name = "tapahtuma_id")
    private Tapahtuma tapahtuma;

    //Parametriton konstruktori
    public Lippu() {
    }

    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
    public Lippu(int hinta, Lipputyyppi lipputyyppi, Tapahtuma tapahtuma) {
        this.hinta = hinta;
        this.lipputyyppi = lipputyyppi;
        this.tapahtuma = tapahtuma;
    }

    //Getterit ja setterit
    public Long getLippu_id() {
        return lippu_id;
    }

    public void setLippu_id(Long lippu_id) {
        this.lippu_id = lippu_id;
    }

    public int getHinta() {
        return hinta;
    }

    public void setHinta(int hinta) {
        this.hinta = hinta;
    }

    public Lipputyyppi getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(Lipputyyppi lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    //ToString
    @Override
    public String toString() {
        return "Lippu [lippu_id=" + lippu_id + ", hinta=" + hinta + ", lipputyyppi=" + lipputyyppi + ", tapahtuma="
                + tapahtuma + "]";
    }

}
