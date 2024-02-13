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
@Table(name="tapahtumajarjestaja_yritys")
public class TapahtumajarjestajaYritys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jarjestaja_id;

    private String nimi;
    private String yhteyshenk_etunimi;
    private String yhteyshenk_sukunimi;
    private String ytunnus;

    public TapahtumajarjestajaYritys(String nimi, String yhteyshenk_etunimi, String yhteyshenk_sukunimi, String ytunnus) {
        super();
        this.nimi = nimi;
        this.yhteyshenk_etunimi = yhteyshenk_etunimi;
        this.yhteyshenk_sukunimi = yhteyshenk_sukunimi;
        this.ytunnus = ytunnus;
    }
    public void setJarjestaja_id(Long jarjestaja_id) {
        this.jarjestaja_id = jarjestaja_id;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setYhteyshenk_etunimi(String yhteyshenk_etunimi) {
        this.yhteyshenk_etunimi = yhteyshenk_etunimi;
    }

    public void setYhteyshenk_sukunimi(String yhteyshenk_sukunimi) {
        this.yhteyshenk_sukunimi = yhteyshenk_sukunimi;
    }

    public void setYtunnus(String ytunnus) {
        this.ytunnus = ytunnus;
    }

    public Long getJarjestaja_id() {
        return jarjestaja_id;
    }

    public String getNimi() {
        return nimi;
    }

    public String getYhteyshenk_etunimi() {
        return yhteyshenk_etunimi;
    }

    public String getYhteyshenk_sukunimi() {
        return yhteyshenk_sukunimi;
    }

    public String getYtunnus() {
        return ytunnus;
    }
    @Override
    public String toString() {
        return "TapahtumajarjestajaYritys [jarjestaja_id=" + jarjestaja_id + ", nimi=" + nimi + ", yhteyshenk_etunimi="
                + yhteyshenk_etunimi + ", yhteyshenk_sukunimi=" + yhteyshenk_sukunimi + ", ytunnus=" + ytunnus + "]";
    }

}
