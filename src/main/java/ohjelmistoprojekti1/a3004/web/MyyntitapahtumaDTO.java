package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.util.List;

import ohjelmistoprojekti1.a3004.domain.Lippu;

public class MyyntitapahtumaDTO {

    private Long id;
    private String kayttaja;
    private String kayttajaRooli;
    private List<Lippu> liput;
    private LocalDateTime aikaleima;

    public MyyntitapahtumaDTO(Long id, String kayttaja, String kayttajaRooli, List<Lippu> liput,
            LocalDateTime aikaleima) {
        this.id = id;
        this.kayttaja = kayttaja;
        this.kayttajaRooli = kayttajaRooli;
        this.liput = liput;
        this.aikaleima = aikaleima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(String kayttaja) {
        this.kayttaja = kayttaja;
    }

    public String getKayttajaRooli() {
        return kayttajaRooli;
    }

    public void setKayttajaRooli(String kayttajaRooli) {
        this.kayttajaRooli = kayttajaRooli;
    }

    public List<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }

    public LocalDateTime getAikaleima() {
        return aikaleima;
    }

    public void setAikaleima(LocalDateTime aikaleima) {
        this.aikaleima = aikaleima;
    }

    @Override
    public String toString() {
        return "MyyntitapahtumaDTO [id=" + id + ", kayttaja=" + kayttaja + ", kayttajaRooli=" + kayttajaRooli
                + ", tapahtumaHetki=" + aikaleima + "]";
    }

}
