package ohjelmistoprojekti1.a3004.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="kayttaja")
public class Kayttaja {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kayttaja_id;

    @ManyToOne
    @JoinColumn(name = "rooli_id")
    private Rooli rooli;

    // @ManyToOne
    // @JoinColumn(name = "postinumero_id")
    // private Postinumero postinumero;

    private String etunimi;

    private String sukunimi;

    private Integer puhnro;

    private String katuosoite;

    // konstruktorit

    public Kayttaja() {
        super();
        this.kayttaja_id = null;
        this.rooli = null;
    //  this.postinumero = null;
        this.etunimi = null;
        this.sukunimi = null;
        this.puhnro = null;
        this.katuosoite = null;
    }
    
    public Kayttaja(Long kayttaja_id, Rooli rooli, //Postinumero postinumero, 
    String etunimi, String sukunimi, Integer puhnro, String katuosoite) {
        this.kayttaja_id = kayttaja_id;
        this.rooli = rooli;
      //  this.postinumero = postinumero;
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

    public Integer getPuhnro() {
        return this.puhnro;
    }

    public void setPuhnro(Integer puhnro) {
        this.puhnro = puhnro;
    }

    public String getKatuosoite() {
        return this.katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }
   
    // toString

    @Override
    public String toString() {
        return "{" +
            " kayttaja_id='" + getKayttaja_id() + "'" +
            ", rooli='" + getRooli() + "'" +
          //  ", postinumero='" + getPostinumero() + "'" +
            ", etunimi='" + getEtunimi() + "'" +
            ", sukunimi='" + getSukunimi() + "'" +
            ", puhnro='" + getPuhnro() + "'" +
            ", katuosoite='" + getKatuosoite() + "'" +
            "}";
    }
   
    
}
