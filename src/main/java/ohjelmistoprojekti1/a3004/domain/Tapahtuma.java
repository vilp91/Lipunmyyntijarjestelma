package ohjelmistoprojekti1.a3004.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Long tapahtumaId;

    @NotNull
    @NotBlank(message = "Tapahtuman nimi on pakollinen tieto")
    private String tapahtumanNimi;

    @NotBlank(message = "Paikka ja katuosoite ovat pakollisia tietoja")
    private String paikka, katuosoite;

    @NotNull(message = "Tapahtuman alkuaika on pakollinen tieto")
    @FutureOrPresent(message = "Tapahtuma-aika ei voi olla menneisyydessä")
    private LocalDateTime alku;
    private LocalDateTime loppu;
    
    @Min(value = 1, message = "Lippujen lukumäärä on oltava vähintään 1")
    private int lippuLukum;

    private int myydytLiputLukum = 0;

    @OneToMany(mappedBy = "tapahtuma")
    @JsonIgnore
    private List<TapahtumanLipputyyppi> tapahtumanLipputyypit;

    @JsonIgnore
    private boolean poistettu = false;

    // Parametriton konstruktori
    public Tapahtuma() {
    }

    public Tapahtuma(String tapahtumanNimi) {
        this.tapahtumanNimi = tapahtumanNimi;
    }

    public Tapahtuma(String tapahtumanNimi, String paikka, String katuosoite, LocalDateTime alku,
            LocalDateTime loppu,
            int lippuLukum) {
        this.tapahtumanNimi = tapahtumanNimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku = alku;
        this.loppu = loppu;
        this.lippuLukum = lippuLukum;
        
    }
    

    public Tapahtuma(String tapahtumanNimi, String paikka, String katuosoite, LocalDateTime alku,
            LocalDateTime loppu,
            int lippuLukum, List<TapahtumanLipputyyppi> tapahtumanLipputyypit) {
        this.tapahtumanNimi = tapahtumanNimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku = alku;
        this.loppu = loppu;
        this.lippuLukum = lippuLukum;
        this.tapahtumanLipputyypit = tapahtumanLipputyypit;
    }

    public Long getTapahtumaId() {
        return tapahtumaId;
    }

    public void setTapahtumaId(Long tapahtumaId) {
        this.tapahtumaId = tapahtumaId;
    }

    public String getTapahtumanNimi() {
        return tapahtumanNimi;
    }

    public void setTapahtumanNimi(String tapahtumanNimi) {
        this.tapahtumanNimi = tapahtumanNimi;
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

    public int getLippuLukum() {
        return lippuLukum;
    }

    public void setLippu_lukum(int lippuLukum) {
        this.lippuLukum = lippuLukum;
    }

    public int getMyydytLiputLukum() {
        return myydytLiputLukum;
    }

    public void setMyydytLiputLukum(int myydytLiputLukum) {
        this.myydytLiputLukum = myydytLiputLukum;
    }

    public List<TapahtumanLipputyyppi> getTapahtumanLipputyypit() {
        return tapahtumanLipputyypit;
    }

    public void setTapahtuman_lipputyypit(List<TapahtumanLipputyyppi> tapahtumanLipputyypit) {
        this.tapahtumanLipputyypit = tapahtumanLipputyypit;
    }

    public boolean isPoistettu() {
        return poistettu;
    }

    public void setPoistettu(boolean poistettu) {
        this.poistettu = poistettu;
    }

    @Override
    public String toString() {
        return "Tapahtuma [tapahtumaId=" + tapahtumaId + ", tapahtumanNimi=" + tapahtumanNimi + ", paikka=" + paikka
                + ", katuosoite=" + katuosoite + ", alku=" + alku + ", loppu=" + loppu + ", lippuLukum=" + lippuLukum
                + ", myydytLiputLukum=" + myydytLiputLukum + ", tapahtumanLipputyypit=" + tapahtumanLipputyypit
                + ", poistettu=" + poistettu + "]";
    }


}
