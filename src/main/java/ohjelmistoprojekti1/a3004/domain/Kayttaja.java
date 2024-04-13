package ohjelmistoprojekti1.a3004.domain;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "kayttaja")
public class Kayttaja {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kayttajaId;

    @ManyToOne
    @JoinColumn(name = "rooliId")
    // @JsonIgnore
    private Rooli rooli;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kayttaja")
    @JsonIgnore
    private List<Myyntitapahtuma> myyntitapahtumat;

    @NotBlank
    private String etunimi;

    @NotBlank
    private String sukunimi;

    private String puhnro;

    private String katuosoite;

    // @JsonIgnore
    @NotBlank
    private String salasana;

    // @JsonIgnore
    @Column(unique = true)
    @NotBlank
    private String kayttajanimi;

    // konstruktorit
    public Kayttaja() {
    }

    public Kayttaja(Rooli rooli, List<Myyntitapahtuma> myyntitapahtumat, @NotBlank String etunimi,
            @NotBlank String sukunimi, String puhnro, String katuosoite, @NotBlank String salasana, String kayttajanimi) {
        this.rooli = rooli;
        this.myyntitapahtumat = myyntitapahtumat;
        //Mahdollinen ongelma: Overrideable methodcall in constructor.
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.puhnro = puhnro;
        this.katuosoite = katuosoite;
        this.kayttajanimi = kayttajanimi;
        setSalasana(salasana);
    }

    // getterit ja setterit
    public Long getKayttajaId() {
        return this.kayttajaId;
    }

    public void setKayttaja_id(Long kayttaja_id) {
        this.kayttajaId = kayttaja_id;
    }

    public Rooli getRooli() {
        return this.rooli;
    }

    public void setRooli(Rooli rooli) {
        this.rooli = rooli;
    }

    public String getEtunimi() {
        return this.etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return this.sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getPuhnro() {
        return this.puhnro;
    }

    public void setPuhnro(String puhnro) {
        this.puhnro = puhnro;
    }

    public String getKatuosoite() {
        return this.katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public List<Myyntitapahtuma> getMyyntitapahtumat() {
        return myyntitapahtumat;
    }

    public void setMyyntitapahtumat(List<Myyntitapahtuma> myyntitapahtumat) {
        this.myyntitapahtumat = myyntitapahtumat;
    }

    public String getKayttajanimi() {
        return kayttajanimi;
    }

    public void setKayttajanimi(String kayttajanimi) {
        this.kayttajanimi = kayttajanimi;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = PASSWORD_ENCODER.encode(salasana);
    }

    @Override
    public String toString() {
        return "Kayttaja [kayttajaId=" + kayttajaId + ", rooli=" + rooli + ", etunimi=" + etunimi + ", sukunimi="
                + sukunimi + ", puhnro=" + puhnro + ", katuosoite=" + katuosoite + "]";
    }

}
