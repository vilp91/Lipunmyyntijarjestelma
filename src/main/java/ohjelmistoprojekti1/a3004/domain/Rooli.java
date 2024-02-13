package ohjelmistoprojekti1.a3004.domain;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;



@Entity
@Table(name="rooli")
public class Rooli {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rooli_id;

    @NotBlank
    private String rooli;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kayttaja")
    @JsonIgnore
    private List<Kayttaja> kayttajat;

    // konstruktorit

     public Rooli() {
        super();
    }

    public Rooli(@NotBlank String rooli, List<Kayttaja> kayttajat) {
        this.rooli = rooli;
        this.kayttajat = kayttajat;
    }

    // getterit ja setterit

    public Long getRooli_id() {
        return this.rooli_id;
    }

    public void setRooli_id(Long rooli_id) {
        this.rooli_id = rooli_id;
    }

    public String getRooli() {
        return this.rooli;
    }

    public void setRooli(String rooli) {
        this.rooli = rooli;
    }

        public List<Kayttaja> getKayttajat() {
        return kayttajat;
    }

    public void setKayttajat(List<Kayttaja> kayttajat) {
        this.kayttajat = kayttajat;
    }

    @Override
    public String toString() {
        return "Rooli [rooli_id=" + rooli_id + ", rooli=" + rooli + ", kayttajat=" + kayttajat + "]";
    }


}