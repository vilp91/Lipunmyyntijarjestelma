package ohjelmistoprojekti1.a3004.domain;

import java.time.LocalDate;
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
@Table(name = "myyntitapahtuma")        // täsmälleen se kirjoitusasu, mikä tulee tietokantaan
public class Myyntitapahtuma {          // luokan nimet CamelCasella

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myyntitapahtuma_id;

    @ManyToOne
    @JoinColumn(name = "kayttaja_id")   // linkitettävän luokan primary key
    private Kayttaja kayttaja;

    private LocalDate pvm = LocalDate.now(); // määritetään myyntitapahtumaan kuluvan päivän päiväys automaattisesti

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myyntitapahtuma")     // en ole varma cascadetypestä.. ymmärtäiskö joku enemmän?
    @JsonIgnore                                                             // tarkoittaa kai sitä että jos esim. poistaa myyntitapahtuman niin se poistaa myös sen myyntitapahtumarivin                                              
    private List<Myyntitapahtumarivi> myyntitapahtumarivit;

    public Myyntitapahtuma() {}          // mulla on tapana tehdä kaikkiin luokkiin tyhjä konstruktori, voidaan poistella jos on turhia

    public Myyntitapahtuma(Long myyntitapahtuma_id) {
        this.myyntitapahtuma_id = myyntitapahtuma_id;
    }

    public Myyntitapahtuma(Long myyntitapahtuma_id, Kayttaja kayttaja, LocalDate pvm,
            List<Myyntitapahtumarivi> myyntitapahtumarivit) {
        this.myyntitapahtuma_id = myyntitapahtuma_id;
        this.kayttaja = kayttaja;
        this.pvm = pvm;
        this.myyntitapahtumarivit = myyntitapahtumarivit;
    }

    public Long getMyyntitapahtuma_id() {
        return myyntitapahtuma_id;
    }

    public void setMyyntitapahtuma_id(Long myyntitapahtuma_id) {
        this.myyntitapahtuma_id = myyntitapahtuma_id;
    }

/*     public Kayttaja getKayttaja() {
        return kayttaja;
    } */

/*     public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    } */

    public LocalDate getPvm() {
        return pvm;
    }

    public void setPvm(LocalDate pvm) {
        this.pvm = pvm;
    }

    public List<Myyntitapahtumarivi> getMyyntitapahtumarivit() {
        return myyntitapahtumarivit;
    }

    public void setMyyntitapahtumarivit(List<Myyntitapahtumarivi> myyntitapahtumarivit) {
        this.myyntitapahtumarivit = myyntitapahtumarivit;
    }

    @Override
    public String toString() {
        return "Myyntitapahtuma [myyntitapahtuma_id=" + myyntitapahtuma_id + ", kayttaja=" + kayttaja + ", pvm=" + pvm
                + ", myyntitapahtumarivit=" + myyntitapahtumarivit + "]";
    }
    
}
