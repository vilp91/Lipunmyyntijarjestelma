package ohjelmistoprojekti1.a3004.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    // konstruktorit

    public Rooli() {
        super();
        this.rooli_id = null;
        this.rooli = null;
    }

    public Rooli(Long rooli_id, String rooli) {
        this.rooli_id = rooli_id;
        this.rooli = rooli;
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

    @Override
    public String toString() {
        return "{" +
            " rooli_id='" + getRooli_id() + "'" +
            ", rooli='" + getRooli() + "'" +
            "}";
    }
    



}