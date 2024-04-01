package ohjelmistoprojekti1.a3004.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "myyntitapahtuma")
public class Myyntitapahtuma {       

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myyntitapahtumaId;

    @ManyToOne
    @JoinColumn(name = "kayttajaId")
    private Kayttaja kayttaja;

    private LocalDateTime aikaleima = LocalDateTime.now(); // määritetään myyntitapahtumaan kuluvan päivän päiväys automaattisesti

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myyntitapahtuma")
    @JsonIgnore                                              
    private List<Lippu> liput;

    public Myyntitapahtuma() {
        super();
    }

    public Myyntitapahtuma(Kayttaja kayttaja, LocalDateTime pvm, List<Lippu> liput) {
        this.kayttaja = kayttaja;
        this.aikaleima = pvm;
        this.liput = liput;
    }

    public Long getMyyntitapahtuma_id() {
        return myyntitapahtumaId;
    }

    public void setMyyntitapahtumaId(Long myyntitapahtumaId) {
        this.myyntitapahtumaId = myyntitapahtumaId;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public LocalDateTime getAikaleima() {
        return aikaleima;
    }

    public void setAikaleima(LocalDateTime pvm) {
        this.aikaleima = pvm;
    }

    public List<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }

    @Override
    public String toString() {
        return "Myyntitapahtuma [myyntitapahtumaId=" + myyntitapahtumaId + ", kayttaja=" + kayttaja + ", pvm=" + aikaleima
                + ", liput=" + liput + "]";
    }

}
