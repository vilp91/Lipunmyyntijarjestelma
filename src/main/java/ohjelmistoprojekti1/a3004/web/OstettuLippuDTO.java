package ohjelmistoprojekti1.a3004.web;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OstettuLippuDTO {

    @NotNull(message = "Tapahtuman lipputyyppi on pakollinen")
    private Long tapahtumanLipputyyppi;
    @Min(message = "Osta ainakin yksi lippu", value = 1)
    private int maara;
    
    public OstettuLippuDTO() {
    }

    public OstettuLippuDTO(Long tapahtumanLipputyyppi, int maara) {
        this.tapahtumanLipputyyppi = tapahtumanLipputyyppi;
        this.maara = maara;
    }

    public Long getTapahtumanLipputyyppi() {
        return tapahtumanLipputyyppi;
    }

    public void setTapahtumanLipputyyppi(Long tapahtumanLipputyyppi) {
        this.tapahtumanLipputyyppi = tapahtumanLipputyyppi;
    }

    public int getMaara() {
        return maara;
    }

    public void setMaara(int maara) {
        this.maara = maara;
    }

    @Override
    public String toString() {
        return "OstettuLippuDTO [tapahtumanLipputyyppi=" + tapahtumanLipputyyppi + ", maara=" + maara + "]";
    }

    

}
