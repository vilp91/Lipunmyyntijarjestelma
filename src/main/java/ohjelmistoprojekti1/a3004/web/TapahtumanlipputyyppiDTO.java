package ohjelmistoprojekti1.a3004.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TapahtumanlipputyyppiDTO {

    private Long id;
    @NotNull(message = "Hinta on pakollinen")
    @Positive(message = "Hinnan pitää olla positiivinen")
    private float hinta;
    @NotNull(message = "Valitse tapahtuma")
    private Long tapahtuma;
    @NotNull(message = "Lipputyyppi Id on pakollinen")
    private Long lipputyyppiId;
    private String lipputyyppi;
    private long LipputyyppiLippuLukum;
    private int LippuLukum;

    
    public TapahtumanlipputyyppiDTO() {
    }

    public TapahtumanlipputyyppiDTO(float hinta, Long tapahtuma, Long lipputyyppiId
    ) {
        this.hinta = hinta;
        this.tapahtuma = tapahtuma;
        this.lipputyyppiId = lipputyyppiId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getHinta() {
        return hinta;
    }

    public void setHinta(float hinta) {
        this.hinta = hinta;
    }

    public Long getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(Long tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    public Long getLipputyyppiId() {
        return lipputyyppiId;
    }

    public void setLipputyyppiId(Long lipputyyppiId) {
        this.lipputyyppiId = lipputyyppiId;
    }

    public String getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(String lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    public long getLipputyyppiLippuLukum() {
        return LipputyyppiLippuLukum;
    }

    public void setLipputyyppiLippuLukum(long LipputyyppiLippuLukum) {
        this.LipputyyppiLippuLukum = LipputyyppiLippuLukum;
    }

    public int getLippuLukum() {
        return this.LippuLukum;
    }

    public void setLippuLukum(int LippuLukum) {
        this.LippuLukum = LippuLukum;
    }

    @Override
    public String toString() {
        return "TapahtumanlipputyyppiDTO [id=" + id + ", hinta=" + hinta + ", tapahtuma=" + tapahtuma
                + ", lipputyyppiId=" + lipputyyppiId + ", lipputyyppi=" + lipputyyppi + "]";
    }
    
}
