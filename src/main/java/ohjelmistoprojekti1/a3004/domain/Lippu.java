package ohjelmistoprojekti1.a3004.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
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
    private Long lippuId;

    @Column(unique = true)
    private UUID lippunumero = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "tapahtumanLipputyyppiId")
    private TapahtumanLipputyyppi tapahtumanLipputyyppi;

    @ManyToOne
    @JoinColumn(name = "myyntitapahtumaId")
    private Myyntitapahtuma myyntitapahtuma;

    private float hinta;

    private LocalDateTime kaytetty = null;

    //Parametriton konstruktori
    public Lippu() {
    }
    
    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
    public Lippu(TapahtumanLipputyyppi tapahtumanLipputyyppi, Myyntitapahtuma myyntitapahtuma, float hinta) {
        this.tapahtumanLipputyyppi = tapahtumanLipputyyppi;
        this.myyntitapahtuma = myyntitapahtuma;
        this.hinta = hinta;
    }

    //Getterit ja setterit
    public Long getLippu_id() {
        return lippuId;
    }

    public void setLippu_id(Long lippu_id) {
        this.lippuId = lippu_id;
    }

    public UUID getLippunumero() {
        return lippunumero;
    }

    public void setLippunumero(UUID lippunumero) {
        this.lippunumero = lippunumero;
    }

    public TapahtumanLipputyyppi getTapahtumanLipputyyppi() {
        return tapahtumanLipputyyppi;
    }

    public void setTapahtuman_lipputyyppi(TapahtumanLipputyyppi tapahtumanLipputyyppi) {
        this.tapahtumanLipputyyppi = tapahtumanLipputyyppi;
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

    public LocalDateTime getKaytetty() {
        return kaytetty;
    }

    public void setKaytetty(LocalDateTime kaytetty) {
        this.kaytetty = kaytetty;
    }

    @Override
    public String toString() {
        return "Lippu [lippuId=" + lippuId + ", lippunumero=" + lippunumero + ", tapahtumanLipputyyppi="
                + tapahtumanLipputyyppi + ", myyntitapahtuma=" + myyntitapahtuma + ", hinta=" + hinta + ", kaytetty="
                + kaytetty + "]";
    }

}
