package sr.unasat.library.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Dienst {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dienstType_id", referencedColumnName = "id")
    private DienstType dienstType;

    private LocalDateTime datum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aangemaaktDoor", referencedColumnName = "id")
    private Gebruiker aangemaaktDoor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "afgehandeldDoor", referencedColumnName = "id")
    private Gebruiker afgehandeldDoor;

    private String opmerking;

    @ManyToOne
    @JoinColumn(name = "lidmaatschapId", nullable = false, referencedColumnName = "id")
    private Lidmaatschap lidmaatschap;

    @Column(nullable = false, columnDefinition = "BIT default 0")
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

    public Gebruiker getAfgehandeldDoor() {
        return afgehandeldDoor;
    }

    public void setAfgehandeldDoor(Gebruiker afgehandeldDoor) {
        this.afgehandeldDoor = afgehandeldDoor;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public Lidmaatschap getLidmaatschap() {
        return lidmaatschap;
    }

    public void setLidmaatschap(Lidmaatschap lidmaatschap) {
        this.lidmaatschap = lidmaatschap;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }
}
