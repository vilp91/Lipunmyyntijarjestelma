/* package ohjelmistoprojekti1.a3004.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="postinumero")
public class Postinumero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postinumero_id;

    @ManyToOne
    @JoinColumn(name = "kaupunki_id")
    private Kaupunki kaupunki;

    @NotBlank
    private String postitoimipaikka;

    public Postinumero() {
        super();
        this.postinumero_id = null;
        this.kaupunki = null;
        this.postitoimipaikka = null;
    }
    public Postinumero(Long postinumero_id, Kaupunki kaupunki, 
    String postitoimipaikka) {
        this.postinumero_id = postinumero_id;
        this.kaupunki = kaupunki;
        this.postitoimipaikka = postitoimipaikka;
    }

    public Long getPostinumero_id() {
        return this.postinumero_id;
    }

    public void setPostinumero_id(Long postinumero_id) {
        this.postinumero_id = postinumero_id; 
    }

    public Kaupunki getKaupunki() {
        return this.kaupunki;
    }

    public void setKaupunki(Kaupunki kaupunki) {
        this.kaupunki = kaupunki; 
    }

    public String getPostitoimipaikka(String postitoimipaikka) {
        return this.postitoimipaikka;
    }

    public void setPostitoimipaikka(String postitoimipaikka) {
        this.postitoimipaikka = postitoimipaikka;
    }
    @Override
    public String toString() {
        return "Postinumero [postinumero_id=" + postinumero_id + ", kaupunki=" + kaupunki + ", postitoimipaikka="
                + postitoimipaikka + "]";
    }
} */