/* package ohjelmistoprojekti1.a3004.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alennus")
public class Alennus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alennus_id;
    private int alennus;

    @ManyToOne
    @JoinColumn(name = "lipputyyppi_id")
    private Lipputyyppi lipputyyppi;

    //Parametriton konstruktori
    public Alennus() {
    }

    //Parametrillinen konstruktori, ei ID:tä, koska se autogeneroituu.
    public Alennus(Lipputyyppi lipputyyppi, int alennus) {
        this.lipputyyppi = lipputyyppi;
        this.alennus = alennus;
    }

    //Getterit ja setterit
    public Long getAlennus_id() {
        return alennus_id;
    }

    public void setAlennus_id(Long alennus_id) {
        this.alennus_id = alennus_id;
    }

    public Lipputyyppi getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi_id(Lipputyyppi lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    public int getAlennus() {
        return alennus;
    }

    public void setAlennus(int alennus) {
        this.alennus = alennus;
    }

    //ToString
    @Override
    public String toString() {
        return "Alennus [alennus_id=" + alennus_id + ", alennus=" + alennus + ", lipputyyppi_id=" + lipputyyppi
                + "]";
    }

}
 */