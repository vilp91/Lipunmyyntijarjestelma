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
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tapahtuma")
public class Tapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tapahtuma_id;

    @NotNull
    @NotBlank(message = "Tapahtuman nimi on pakollinen tieto")
    private String tapahtuman_nimi;

    @NotBlank(message = "Paikka ja katuosoite ovat pakollisia tietoja")
    private String paikka, katuosoite;

    @NotNull(message = "Tapahtuman alkuaika on pakollinen tieto")
    @FutureOrPresent(message = "Tapahtuma-aika ei voi olla menneisyydessä")
    private LocalDateTime alku;
    private LocalDateTime loppu;
    
    @Min(value = 1, message = "Lippujen lukumäärä on oltava vähintään 1")
    private int lippu_lukum;

    private int myydyt_liput_lukum = 0;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tapahtuma")
    @JsonIgnore
    private List<TapahtumanLipputyyppi> tapahtuman_lipputyypit;

    // Parametriton konstruktori
    public Tapahtuma() {
    }

    public Tapahtuma(String tapahtuman_nimi) {
        this.tapahtuman_nimi = tapahtuman_nimi;
    }

    public Tapahtuma(String tapahtuman_nimi, String paikka, String katuosoite, LocalDateTime alku,
            LocalDateTime loppu,
            int lippu_lukum) {
        this.tapahtuman_nimi = tapahtuman_nimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku = alku;
        this.loppu = loppu;
        this.lippu_lukum = lippu_lukum;
    }
    

    public Tapahtuma(String tapahtuman_nimi, String paikka, String katuosoite, LocalDateTime alku,
            LocalDateTime loppu,
            int lippu_lukum, List<TapahtumanLipputyyppi> tapahtuman_lipputyypit) {
        this.tapahtuman_nimi = tapahtuman_nimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku = alku;
        this.loppu = loppu;
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

    public LocalDateTime getAlku() {
        return alku;
    }

    public void setAlku(LocalDateTime alku) {
        this.alku = alku;
    }

    public LocalDateTime getLoppu() {
        return loppu;
    }

    public void setLoppu(LocalDateTime loppu) {
        this.loppu = loppu;
    }

    public int getLippu_lukum() {
        return lippu_lukum;
    }

    public void setLippu_lukum(int lippu_lukum) {
        this.lippu_lukum = lippu_lukum;
    }

    public int getMyydyt_liput_lukum() {
        return myydyt_liput_lukum;
    }

    public void setMyydyt_liput_lukum(int myydyt_liput_lukum) {
        this.myydyt_liput_lukum = myydyt_liput_lukum;
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
                + ", katuosoite=" + katuosoite + ", alku=" + alku + ", loppu=" + loppu + ", lippu_lukum=" + lippu_lukum
                + ", myydyt_liput_lukum=" + myydyt_liput_lukum + ", tapahtuman_lipputyypit=" + tapahtuman_lipputyypit
                + "]";
    }


}
