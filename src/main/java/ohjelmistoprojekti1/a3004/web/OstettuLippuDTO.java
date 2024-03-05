package ohjelmistoprojekti1.a3004.web;

public class OstettuLippuDTO {

    private Long tapahtumanLipputyyppi;
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
