package ohjelmistoprojekti1.a3004.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tapahtuma")
public class Tapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tapahtuma_id;
    private String tapahtuman_nimi;
    private String paikka, katuosoite;
    private LocalDate alku_pvm, loppu_pvm;
    private int lippu_lukum, perus_hinta;

    /* NÄMÄ KOMMENTIT VOI AVATA KUN TAPAHTUMANJARJESTAJA TAULU ON VALMIS 

    @ManyToOne
    @JoinColumn(name = "jarjestaja_id")
    private Tapahtumanjarjestaja tapahtumanjarjestaja;
     */

 /* NÄMÄ KOMMENTIT VOI AVATA KUN POSTINUMERO TAULU ON VALMIS 
    @ManyToOne
    @JoinColumn(name = "postinumero_id")
    private Postinumero postinumero;

     */
    //Parametriton konstruktori
    public Tapahtuma() {
    }

    /* NÄMÄ KOMMENTIT VOI AVATA KUN POSTINUMERO JA TAPAHTUMANJARJESTAJA TAULUT OVAT VALMIITA 

    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
    public Tapahtuma(String tapahtuman_nimi, String paikka, String katuosoite, LocalDate alku_pvm, LocalDate loppu_pvm,
            int lippu_lukum, int perus_hinta, Tapahtumanjarjestaja tapahtumanjarjestaja, Postinumero postinumero) {
        this.tapahtuman_nimi = tapahtuman_nimi;
        this.paikka = paikka;
        this.katuosoite = katuosoite;
        this.alku_pvm = alku_pvm;
        this.loppu_pvm = loppu_pvm;
        this.lippu_lukum = lippu_lukum;
        this.perus_hinta = perus_hinta;
        this.tapahtumanjarjestaja = tapahtumanjarjestaja;
        this.postinumero = postinumero;
    }

     */
    //Getterit ja setterit
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

    public LocalDate getAlku_pvm() {
        return alku_pvm;
    }

    public void setAlku_pvm(LocalDate alku_pvm) {
        this.alku_pvm = alku_pvm;
    }

    public LocalDate getLoppu_pvm() {
        return loppu_pvm;
    }

    public void setLoppu_pvm(LocalDate loppu_pvm) {
        this.loppu_pvm = loppu_pvm;
    }

    public int getLippu_lukum() {
        return lippu_lukum;
    }

    public void setLippu_lukum(int lippu_lukum) {
        this.lippu_lukum = lippu_lukum;
    }

    public int getPerus_hinta() {
        return perus_hinta;
    }

    public void setPerus_hinta(int perus_hinta) {
        this.perus_hinta = perus_hinta;
    }

    /* NÄMÄ KOMMENTIT VOI AVATA KUN TAPAHTUMANJARJESTAJA TAULU ON VALMIS 

    public Tapahtumanjarjestaja getTapahtumanjarjestaja() {
        return tapahtumanjarjestaja;
    }

    public void setTapahtumanjarjestaja(Tapahtumanjarjestaja tapahtumanjarjestaja) {
        this.tapahtumanjarjestaja = tapahtumanjarjestaja;
    }

     */

 /* NÄMÄ KOMMENTIT VOI AVATA KUN POSTINUMERO TAULU ON VALMIS 

    public Postinumero getPostinumero() {
        return postinumero;
    }

    public void setPostinumero(Postinumero postinumero) {
        this.postinumero = postinumero;
    }

     */

 /* NÄMÄ KOMMENTIT VOI AVATA KUN POSTINUMERO JA TAPAHTUMANJARJESTAJA TAULUT OVAT VALMIITA 
    @Override
    public String toString() {
        return "Tapahtuma [tapahtuma_id=" + tapahtuma_id + ", tapahtuman_nimi=" + tapahtuman_nimi + ", paikka=" + paikka
                + ", katuosoite=" + katuosoite + ", alku_pvm=" + alku_pvm + ", loppu_pvm=" + loppu_pvm
                + ", lippu_lukum=" + lippu_lukum + ", perus_hinta=" + perus_hinta + ", tapahtumanjarjestaja="
                + tapahtumanjarjestaja + ", postinumero=" + postinumero + "]";
    }
     */
}
