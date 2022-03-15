package sr.unasat.library.entity;

import javax.persistence.*;

@Entity
public class DienstType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    private String naam;

    private String code;

    private String omschrijving;

    private String actief;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getActief() {
        return actief;
    }

    public void setActief(String actief) {
        this.actief = actief;
    }
}
