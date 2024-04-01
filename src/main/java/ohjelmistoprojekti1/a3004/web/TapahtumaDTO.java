package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.util.List;

public class TapahtumaDTO {
    private Long tapahtuma_id;
    private String tapahtuman_nimi, paikka, katuosoite;
    private LocalDateTime alku, loppu;
    private int lippu_lukum;
    private int myydyt_liput_lukum;
    private List<TapahtumanlipputyyppiDTO> tapahtuman_lipputyypit;

    public TapahtumaDTO() {
    }

    public TapahtumaDTO(Long tapahtuma_id, String tapahtuman_nimi, String paikka, String katuosoite, LocalDateTime alku,
            LocalDateTime loppu, int lippu_lukum, int myydyt_liput_lukum,
            List<TapahtumanlipputyyppiDTO> tapahtuman_lipputyypit) {
        this.tapahtuma_id = tapahtuma_id;
        this.tapahtuman_nimi = tapahtuman_nimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku = alku;
        this.loppu = loppu;
        this.lippu_lukum = lippu_lukum;
        this.myydyt_liput_lukum = myydyt_liput_lukum;
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

    public List<TapahtumanlipputyyppiDTO> getTapahtuman_lipputyypit() {
        return tapahtuman_lipputyypit;
    }

    public void setTapahtuman_lipputyypit(List<TapahtumanlipputyyppiDTO> tapahtuman_lipputyypit) {
        this.tapahtuman_lipputyypit = tapahtuman_lipputyypit;
    }

    @Override
    public String toString() {
        return "TapahtumaDTO [tapahtuma_id=" + tapahtuma_id + ", tapahtuman_nimi=" + tapahtuman_nimi + ", paikka="
                + paikka + ", katuosoite=" + katuosoite + ", alku=" + alku + ", loppu=" + loppu + ", lippu_lukum="
                + lippu_lukum + ", myydyt_liput_lukum=" + myydyt_liput_lukum + ", tapahtuman_lipputyypit="
                + tapahtuman_lipputyypit + "]";
    }

}
