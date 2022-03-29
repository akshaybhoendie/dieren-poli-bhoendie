package sr.unasat.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lidmaatschap {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String voornaam;

    private String achternaam;

    private LocalDate geboorteDatum;

    private LocalDateTime inschrijfDatum;

    private Long lidmaatschapNummer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private Gebruiker gebruiker;

    @OneToMany(mappedBy = "lidmaatschap")
    @JsonIgnore
    private List<Dier> dieren = new ArrayList<>();

    @OneToMany(mappedBy = "lidmaatschap")
    @JsonIgnore
    private List<Dienst> diensten = new ArrayList<>();

    @Column(nullable = false, columnDefinition = "BIT default 0")
    private boolean actief;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public LocalDateTime getInschrijfDatum() {
        return inschrijfDatum;
    }

    public void setInschrijfDatum(LocalDateTime inschrijfDatum) {
        this.inschrijfDatum = inschrijfDatum;
    }

    public Long getLidmaatschapNummer() {
        return lidmaatschapNummer;
    }

    public void setLidmaatschapNummer(Long lidmaatschapNummer) {
        this.lidmaatschapNummer = lidmaatschapNummer;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public List<Dier> getDieren() {
        return dieren;
    }

    public void setDieren(List<Dier> dieren) {
        this.dieren = dieren;
    }

    public List<Dienst> getDiensten() {
        return diensten;
    }

    public void setDiensten(List<Dienst> diensten) {
        this.diensten = diensten;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }
}
