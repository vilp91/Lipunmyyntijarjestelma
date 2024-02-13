package ohjelmistoprojekti1.a3004.domain;


import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name="kayttaja")
public class Kayttaja {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kayttaja_id;

    @ManyToOne
    @JoinColumn(name = "rooli_id")
    private Rooli rooli;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myyntitapahtuma")
    private List<Myyntitapahtuma> myyntitapahtumat;

    // @ManyToOne
    // @JoinColumn(name = "postinumero_id")
    // private Postinumero postinumero;

    @NotBlank
    private String etunimi;

    @NotBlank
    private String sukunimi;

    private String puhnro;

    private String katuosoite;

    // konstruktorit

    public Kayttaja() {
    }
    
    public Kayttaja(Rooli rooli, List<Myyntitapahtuma> myyntitapahtumat, @NotBlank String etunimi,
            @NotBlank String sukunimi, String puhnro, String katuosoite) {
        this.rooli = rooli;
        this.myyntitapahtumat = myyntitapahtumat;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.puhnro = puhnro;
        this.katuosoite = katuosoite;
    }
    
    // getterit ja setterit


    public Long getKayttaja_id() {
        return this.kayttaja_id;
    }

    public void setKayttaja_id(Long kayttaja_id) {
        this.kayttaja_id = kayttaja_id;
    }

    public Rooli getRooli() {
        return this.rooli;
    }

    public void setRooli(Rooli rooli) {
        this.rooli = rooli;
    }

   // public Postinumero getPostinumero() {
   //     return this.postinumero;
   // }

   // public void setPostinumero(Postinumero postinumero) {
   //     this.postinumero = postinumero;
   // }

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

    // toString
    @Override
    public String toString() {
        return "Kayttaja [kayttaja_id=" + kayttaja_id + ", rooli=" + rooli + ", myyntitapahtumat=" + myyntitapahtumat
                + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", puhnro=" + puhnro + ", katuosoite="
                + katuosoite + "]";
    }   
    
}
