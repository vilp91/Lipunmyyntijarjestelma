package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.util.List;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.Lippu;

public class MyyntitapahtumaLuontiDTO {

    private Kayttaja kayttaja;
    private Long kayttaja_id;
    private LocalDateTime aikaleima = LocalDateTime.now();
    private List<Lippu> liput;

    public MyyntitapahtumaLuontiDTO() {
    }

    public MyyntitapahtumaLuontiDTO(Kayttaja kayttaja, List<Lippu> liput) {
        this.kayttaja = kayttaja;
        this.liput = liput;
    }

    public MyyntitapahtumaLuontiDTO(Kayttaja kayttaja, LocalDateTime aikaleima, List<Lippu> liput) {
        this.kayttaja = kayttaja;
        this.aikaleima = aikaleima;
        this.liput = liput;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public Long getKayttaja_id() {
        return kayttaja_id;
    }

    public void setKayttaja_id(Long kayttaja_id) {
        this.kayttaja_id = kayttaja_id;
    }

    public LocalDateTime getAikaleima() {
        return aikaleima;
    }

    public void setAikaleima(LocalDateTime aikaleima) {
        this.aikaleima = aikaleima;
    }

    public List<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }

    @Override
    public String toString() {
        return "MyyntitapahtumaLuontiDTO [kayttaja=" + kayttaja + ", aikaleima=" + aikaleima + ", liput=" + liput + "]";
    }

}
