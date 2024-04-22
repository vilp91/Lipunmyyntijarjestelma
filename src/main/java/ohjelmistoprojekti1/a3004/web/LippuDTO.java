package ohjelmistoprojekti1.a3004.web;

import java.util.UUID;

public class LippuDTO {
    
    private Long id;
    private UUID lippunumero;
    private String tyyppi;
    private String tapahtuma;
    private float hinta;

    public LippuDTO() {
    }    

    public LippuDTO(Long id, UUID lippunumero, String tyyppi, String tapahtuma, float hinta) {
        this.id = id;
        this.lippunumero = lippunumero;
        this.tyyppi = tyyppi;
        this.tapahtuma = tapahtuma;
        this.hinta = hinta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getLippunumero() {
        return lippunumero;
    }

    public void setLippunumero(UUID lippunumero) {
        this.lippunumero = lippunumero;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(String tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    public float getHinta() {
        return hinta;
    }

    public void setHinta(float hinta) {
        this.hinta = hinta;
    }

    @Override
    public String toString() {
        return "LippuDTO [id=" + id + ", lippunumero=" + lippunumero + ", tyyppi=" + tyyppi + ", tapahtuma=" + tapahtuma
                + ", hinta=" + hinta + "]";
    }

}
