package ohjelmistoprojekti1.a3004.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "kaupunki")
public class Kaupunki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kaupunki_id;
    private String nimi;


/* NÄMÄ KOMMENTIT VOI AVATA KUN POSTINUMERO TAULU ON VALMIS

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kaupunki")
    private List<Postinumero> postinumero;

*/

    //Parametriton konstruktori    
    public Kaupunki() {
    }
     
    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu. 
    public Kaupunki(String nimi) {   
        super();
        this.nimi = nimi;  
    }

    //Getterit ja setterit
    public Long getKaupunki_id() {
        return kaupunki_id;
    }

    public void setKaupunki_id(Long kaupunki_id) {
        this.kaupunki_id = kaupunki_id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

/*  NÄMÄ KOMMENTIT VOI AVATA KUN POSTINUMERO TAULU ON VALMIS

    public List<Postinumero> getPostinumero() {
        return postinumero;
    }

    public void setPostinumerot(List<Postinumero> postinumero) {
        this.postinumerot = postinumero;
    }

*/
    //ToString
    @Override
    public String toString() {
        return "Kaupunki [kaupunki_id=" + kaupunki_id + ", nimi=" + nimi + "]";
    }

}