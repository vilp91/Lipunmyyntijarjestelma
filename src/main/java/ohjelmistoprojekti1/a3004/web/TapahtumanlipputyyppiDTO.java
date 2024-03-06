package ohjelmistoprojekti1.a3004.web;

public class TapahtumanlipputyyppiDTO {
    private float hinta;
    private Long tapahtuma;
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
