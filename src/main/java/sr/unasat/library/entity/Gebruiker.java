package sr.unasat.library.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    private String naam;

    private String achternaam;

    @Enumerated(EnumType.STRING)
    private RolType rolType;

    private LocalDate geboorteDatum;

    @OneToOne(mappedBy = "gebruiker", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Lidmaatschap lidmaatschap;

    @Column(nullable = false, columnDefinition = "BIT default 0")
    private boolean actief;

    public Gebruiker() {
    }

    public Gebruiker(GebruikerBuilder gebruikerBuilder) {
        this.id = gebruikerBuilder.id;
        this.naam = gebruikerBuilder.naam;
        this.achternaam = gebruikerBuilder.achternaam;
        this.rolType = gebruikerBuilder.rolType;
        this.geboorteDatum = gebruikerBuilder.geboorteDatum;
        this.actief = gebruikerBuilder.actief;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public RolType getRolType() {
        return rolType;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public boolean isActief() {
        return actief;
    }

    public static class GebruikerBuilder {

        private Long id;
        private String naam;
        private String achternaam;
        private RolType rolType;
        private LocalDate geboorteDatum;
        private boolean actief;

        public GebruikerBuilder() {
        }

        public GebruikerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GebruikerBuilder naam(String naam) {
            this.naam = naam;
            return this;
        }

        public GebruikerBuilder achternaam(String achternaam) {
            this.achternaam = achternaam;
            return this;
        }

        public GebruikerBuilder rolType(RolType rolType) {
            this.rolType = rolType;
            return this;
        }

        public GebruikerBuilder geboorteDatum(LocalDate geboorteDatum) {
            this.geboorteDatum = geboorteDatum;
            return this;
        }

        public GebruikerBuilder actief(boolean actief) {
            this.actief = actief;
            return this;
        }

        public Gebruiker build() {
            return new Gebruiker(this);
        }
    }
}