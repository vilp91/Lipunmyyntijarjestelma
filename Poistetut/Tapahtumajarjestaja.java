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
@Table
public class Tapahtumajarjestaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jarjestaja_id;

    @ManyToOne
    @JoinColumn(name = "postinumero_id")
    private Postinumero postinumero;

    @NotBlank
    private String katuosoite;
    @NotBlank
    private String tilinumero;
    @NotBlank
    private Integer puh;
    @NotBlank
    private String sahkoposti;

    public Tapahtumajarjestaja() {
        super();
        this.jarjestaja_id = null;
        this.postinumero = null;
        this.katuosoite = null;
        this.tilinumero = null;
        this.puh = null;
        this.sahkoposti = null;
    }

    public Tapahtumajarjestaja(Long jarjestaja_id, Postinumero postinumero, String katuosoite, String tilinumero,
    Integer puh, String sahkoposti) {
        this.jarjestaja_id = jarjestaja_id;
        this.postinumero = postinumero;
        this.katuosoite = katuosoite;
        this.tilinumero = tilinumero;
        this.puh = puh;
        this.sahkoposti = sahkoposti;
    }

    public void setJarjestaja_id(Long jarjestaja_id) {
        this.jarjestaja_id = jarjestaja_id;
    }

    public void setPostinumero(Postinumero postinumero) {
        this.postinumero = postinumero;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public void setTilinumero(String tilinumero) {
        this.tilinumero = tilinumero;
    }

    public void setPuh(Integer puh) {
        this.puh = puh;
    }

    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }

    public Long getJarjestaja_id() {
        return jarjestaja_id;
    }

    public Postinumero getPostinumero() {
        return postinumero;
    }

    public String getKatuosoite() {
        return katuosoite;
    }

    public String getTilinumero() {
        return tilinumero;
    }

    public Integer getPuh() {
        return puh;
    }

    public String getSahkoposti() {
        return sahkoposti;
    }

        @Override
    public String toString() {
        return "Tapahtumajarjestaja [jarjestaja_id=" + jarjestaja_id + ", postinumero=" + postinumero + ", katuosoite="
                + katuosoite + ", tilinumero=" + tilinumero + ", puh=" + puh + ", sahkoposti=" + sahkoposti + "]";
    }


}
 */