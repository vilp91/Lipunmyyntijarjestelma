package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class MyyntitapahtumaDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Summa on pakollinen")
    private float summa;
    private LocalDateTime aika;
    @NotBlank(message = "Pakollinen")
    private List<LippuDTO> liput;
    
    public MyyntitapahtumaDTO() {
    }

    public MyyntitapahtumaDTO(float summa, LocalDateTime aika, List<LippuDTO> liput) {
        this.summa = summa;
        this.aika = aika;
        this.liput = liput;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSumma() {
        return summa;
    }

    public void setSumma(float summa) {
        this.summa = summa;
    }

    public LocalDateTime getAika() {
        return aika;
    }

    public void setAika(LocalDateTime aika) {
        this.aika = aika;
    }

    public List<LippuDTO> getLiput() {
        return liput;
    }

    public void setLiput(List<LippuDTO> liput) {
        this.liput = liput;
    }

    @Override
    public String toString() {
        return "MyyntitapahtumaDTO [id=" + id + ", summa=" + summa + ", aika=" + aika + "]";
    }

}
