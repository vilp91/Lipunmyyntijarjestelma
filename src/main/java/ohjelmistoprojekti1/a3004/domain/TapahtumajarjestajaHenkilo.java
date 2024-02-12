package ohjelmistoprojekti1.a3004.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;


@Entity
@Table
public class TapahtumajarjestajaHenkilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jarjestaja_id;

    private String etunimi;
    private String sukunimi;
    private String hetu;

    public TapahtumajarjestajaHenkilo() {
    }

    public TapahtumajarjestajaHenkilo(String etunimi, String sukunimi, String hetu) {
        super();
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.hetu = hetu;
    }

    public void setJarjestaja_id(Long jarjestaja_id) {
        this.jarjestaja_id = jarjestaja_id;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public void setHetu(String hetu) {
        this.hetu = hetu;
    }

    public Long getJarjestaja_id() {
        return jarjestaja_id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public String getHetu() {
        return hetu;
    }

    @Override
    public String toString() {
        return "TapahtumajarjestajaHenkilo [jarjestaja_id=" + jarjestaja_id + ", etunimi=" + etunimi + ", sukunimi="
                + sukunimi + ", hetu=" + hetu + "]";
    }
}
