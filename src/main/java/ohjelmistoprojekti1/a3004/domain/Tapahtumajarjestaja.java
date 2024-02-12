package ohjelmistoprojekti1.a3004.domain;

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
    private String puh;
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

    public Tapahtumajarjestaja(Long tapahtumajarjestaja_id, Postinumero postinumero, String katuosoite, String tilinumero,
    Integer puh, String sahkoposti) {
        this.tapahtumajarjestaja_id = tapahtumajarjestaja_id;
        this.postinumero = postinumero;
        this.katuosoite = katuosoite;
        this.tilinumero = tilinumero;
        this.puh = puh;
        this.sahkoposti = sahkoposti;
    }




}
