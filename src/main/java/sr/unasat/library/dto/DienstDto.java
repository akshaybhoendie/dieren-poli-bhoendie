package sr.unasat.library.dto;

import sr.unasat.library.entity.DienstType;
import sr.unasat.library.entity.Gebruiker;
import sr.unasat.library.entity.Lidmaatschap;
import java.time.LocalDateTime;

public class DienstDto {

    private Long id;
    private DienstType dienstType;
    private LocalDateTime datum;
    private Gebruiker aangemaaktDoor;
    private Gebruiker afgehanldDoor;
    private Lidmaatschap lidmaatschap;
    private String opmerking;
    private boolean actief;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DienstType getDienstType() {
        return dienstType;
    }

    public void setDienstType(DienstType dienstType) {
        this.dienstType = dienstType;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public Gebruiker getAangemaaktDoor() {
        return aangemaaktDoor;
    }

    public void setAangemaaktDoor(Gebruiker aangemaaktDoor) {
        this.aangemaaktDoor = aangemaaktDoor;
    }

    public Gebruiker getAfgehanldDoor() {
        return afgehanldDoor;
    }

    public void setAfgehanldDoor(Gebruiker afgehanldDoor) {
        this.afgehanldDoor = afgehanldDoor;
    }

    public Lidmaatschap getLidmaatschap() {
        return lidmaatschap;
    }

    public void setLidmaatschap(Lidmaatschap lidmaatschap) {
        this.lidmaatschap = lidmaatschap;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }
}
