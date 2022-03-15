package sr.unasat.library.dto;

import sr.unasat.library.entity.RolType;

import java.time.LocalDate;

public class GebruikerDto {

    private Long id;
    private String naam;
    private String achternaam;
    private RolType rolType;
    private LocalDate geboorteDatum;
    private boolean actief;

    public GebruikerDto() {
    }

    public GebruikerDto(GebruikerDtoBuilder gebruikerDtoBuilder) {
        this.id = gebruikerDtoBuilder.id;
        this.naam = gebruikerDtoBuilder.naam;
        this.achternaam = gebruikerDtoBuilder.achternaam;
        this.rolType = gebruikerDtoBuilder.rolType;
        this.geboorteDatum = gebruikerDtoBuilder.geboorteDatum;
        this.actief = gebruikerDtoBuilder.actief;
    }

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

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public RolType getRolType() {
        return rolType;
    }

    public void setRolType(RolType rolType) {
        this.rolType = rolType;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public static class GebruikerDtoBuilder{
        private Long id;
        private String naam;
        private String achternaam;
        private RolType rolType;
        private LocalDate geboorteDatum;
        private boolean actief;

        public GebruikerDtoBuilder() {
        }

        public GebruikerDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GebruikerDtoBuilder naam(String naam) {
            this.naam = naam;
            return this;
        }

        public GebruikerDtoBuilder achternaam(String achternaam) {
            this.achternaam = achternaam;
            return this;
        }

        public GebruikerDtoBuilder rolType(RolType rolType) {
            this.rolType = rolType;
            return this;
        }

        public GebruikerDtoBuilder geboorteDatum(LocalDate geboorteDatum) {
            this.geboorteDatum = geboorteDatum;
            return this;
        }

        public GebruikerDtoBuilder actief(boolean actief) {
            this.actief = actief;
            return this;
        }

        public GebruikerDto build() {
            return new GebruikerDto(this);
        }
    }
}
