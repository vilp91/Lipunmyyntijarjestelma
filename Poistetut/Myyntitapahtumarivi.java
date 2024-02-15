/* package ohjelmistoprojekti1.a3004.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "myyntitapahtumarivi")            // täsmälleen se kirjoitusasu, mikä tulee tietokantaan
public class Myyntitapahtumarivi {              // luokan nimet CamelCasella
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long myyntitapahtumarivi_id;

    @OneToOne
    @JoinColumn(name = "lippu_id")              // linkitettävän luokan primary key
    private Lippu lippu;
    
    @ManyToOne
    @JoinColumn(name = "myyntitapahtuma_id")    // linkitettävän luokan primary key
    private Myyntitapahtuma myyntitapahtuma;

    public Myyntitapahtumarivi() {}             // mulla on tapana tehdä kaikkiin luokkiin tyhjä konstruktori, voidaan poistella jos on turhia

    public Myyntitapahtumarivi(Long myyntitapahtumarivi_id, Lippu lippu, Myyntitapahtuma myyntitapahtuma) {
        this.myyntitapahtumarivi_id = myyntitapahtumarivi_id;
        this.lippu = lippu;
        this.myyntitapahtuma = myyntitapahtuma;
    }

    public Long getMyyntitapahtumarivi_id() {
        return myyntitapahtumarivi_id;
    }

    public void setMyyntitapahtumarivi_id(Long myyntitapahtumarivi_id) {
        this.myyntitapahtumarivi_id = myyntitapahtumarivi_id;
    }

    public Lippu getLippu() {
        return lippu;
    }

    public void setLippu(Lippu lippu) {
        this.lippu = lippu;
    }

    public Myyntitapahtuma getMyyntitapahtuma() {
        return myyntitapahtuma;
    }

    public void setMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma) {
        this.myyntitapahtuma = myyntitapahtuma;
    }

    @Override
    public String toString() {
        return "Myyntitapahtumarivi [myyntitapahtumarivi_id=" + myyntitapahtumarivi_id + ", lippu=" + lippu
                + ", myyntitapahtuma=" + myyntitapahtuma + "]";
    }

}
 */