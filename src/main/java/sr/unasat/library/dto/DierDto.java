package sr.unasat.library.dto;

import sr.unasat.library.entity.Lidmaatschap;

import java.time.LocalDate;

public class DierDto {

    private Long id;
    private String naam;
    private Lidmaatschap lidmaatschap    ;
    private LocalDate geboordeDatum;
    private Double gewicht;
    private String categorie;
    private String soort;
    private Boolean overleden;

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

    public Lidmaatschap getLidmaatschap() {
        return lidmaatschap;
    }

    public void setLidmaatschap(Lidmaatschap lidmaatschap) {
        this.lidmaatschap = lidmaatschap;
    }

    public LocalDate getGeboordeDatum() {
        return geboordeDatum;
    }

    public void setGeboordeDatum(LocalDate geboordeDatum) {
        this.geboordeDatum = geboordeDatum;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public Boolean getOverleden() {
        return overleden;
    }

    public void setOverleden(Boolean overleden) {
        this.overleden = overleden;
    }
}
