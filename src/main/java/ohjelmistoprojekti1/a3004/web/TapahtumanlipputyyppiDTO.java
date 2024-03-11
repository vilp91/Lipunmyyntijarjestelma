package ohjelmistoprojekti1.a3004.web;

import jakarta.validation.constraints.NotNull;

public class TapahtumanlipputyyppiDTO {

    @NotNull(message = "Hinta on pakollinen")
    private float hinta;
    @NotNull(message = "Valitse tapahtuma")
    private Long tapahtuma;
    @NotNull(message = "Lipputyyppi on pakollinen")
    private Long lipputyyppi;
    
    public TapahtumanlipputyyppiDTO() {
    }

    public TapahtumanlipputyyppiDTO(float hinta, Long tapahtuma, Long lipputyyppi) {
        this.hinta = hinta;
        this.tapahtuma = tapahtuma;
        this.lipputyyppi = lipputyyppi;
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

    public Long getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(Long lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    @Override
    public String toString() {
        return "TapahtumanlipputyyppiDTO [hinta=" + hinta + ", tapahtuma=" + tapahtuma + ", lipputyyppi=" + lipputyyppi
                + "]";
    }

    
}
