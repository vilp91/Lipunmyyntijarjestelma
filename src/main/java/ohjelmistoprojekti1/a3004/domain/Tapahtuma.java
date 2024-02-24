package ohjelmistoprojekti1.a3004.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tapahtuma")
public class Tapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tapahtuma_id;
    private String tapahtuman_nimi;
    private String paikka, katuosoite;
    private LocalDateTime alku_pvm, loppu_pvm;
    private int lippu_lukum;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tapahtuma")
    @JsonIgnore
    private List<TapahtumanLipputyyppi> tapahtuman_lipputyypit;
    
    //Parametriton konstruktori
    public Tapahtuma() {
    }


    public Tapahtuma(String tapahtuman_nimi) {
        this.tapahtuman_nimi = tapahtuman_nimi;
    }    

    public Tapahtuma(String tapahtuman_nimi, String paikka, String katuosoite, LocalDateTime alku_pvm, LocalDateTime loppu_pvm,
            int lippu_lukum) {
        this.tapahtuman_nimi = tapahtuman_nimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku_pvm = alku_pvm;
        this.loppu_pvm = loppu_pvm;
        this.lippu_lukum = lippu_lukum;
    }


    public Tapahtuma(String tapahtuman_nimi, String paikka, String katuosoite, LocalDateTime alku_pvm, LocalDateTime loppu_pvm,
            int lippu_lukum, List<TapahtumanLipputyyppi> tapahtuman_lipputyypit) {
        this.tapahtuman_nimi = tapahtuman_nimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku_pvm = alku_pvm;
        this.loppu_pvm = loppu_pvm;
        this.lippu_lukum = lippu_lukum;
        this.tapahtuman_lipputyypit = tapahtuman_lipputyypit;
    }

    public Long getTapahtuma_id() {
        return tapahtuma_id;
    }

    public void setTapahtuma_id(Long tapahtuma_id) {
        this.tapahtuma_id = tapahtuma_id;
    }

    public String getTapahtuman_nimi() {
        return tapahtuman_nimi;
    }

    public void setTapahtuman_nimi(String tapahtuman_nimi) {
        this.tapahtuman_nimi = tapahtuman_nimi;
    }

    public String getPaikka() {
        return paikka;
    }

    public void setPaikka(String paikka) {
        this.paikka = paikka;
    }

    public String getKatuosoite() {
        return katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public LocalDateTime getAlku_pvm() {
        return alku_pvm;
    }

    public void setAlku_pvm(LocalDateTime alku_pvm) {
        this.alku_pvm = alku_pvm;
    }

    public LocalDateTime getLoppu_pvm() {
        return loppu_pvm;
    }

    public void setLoppu_pvm(LocalDateTime loppu_pvm) {
        this.loppu_pvm = loppu_pvm;
    }

    public int getLippu_lukum() {
        return lippu_lukum;
    }

    public void setLippu_lukum(int lippu_lukum) {
        this.lippu_lukum = lippu_lukum;
    }

    public List<TapahtumanLipputyyppi> getTapahtuman_lipputyypit() {
        return tapahtuman_lipputyypit;
    }

    public void setTapahtuman_lipputyypit(List<TapahtumanLipputyyppi> tapahtuman_lipputyypit) {
        this.tapahtuman_lipputyypit = tapahtuman_lipputyypit;
    }

    @Override
    public String toString() {
        return "Tapahtuma [tapahtuma_id=" + tapahtuma_id + ", tapahtuman_nimi=" + tapahtuman_nimi + ", paikka=" + paikka
                + ", katuosoite=" + katuosoite + ", alku_pvm=" + alku_pvm + ", loppu_pvm=" + loppu_pvm
                + ", lippu_lukum=" + lippu_lukum + ", tapahtuman_lipputyypit=" + tapahtuman_lipputyypit + "]";
    }

    
    
}
