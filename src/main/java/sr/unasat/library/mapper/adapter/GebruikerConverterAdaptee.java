package sr.unasat.library.mapper.adapter;

import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.entity.Gebruiker;

import java.util.ArrayList;
import java.util.List;

public class GebruikerConverterAdaptee {

    public Gebruiker convertToGebruiker(GebruikerDto gebruikerDto){
        return new Gebruiker
                .GebruikerBuilder()
                .id(gebruikerDto.getId())
                .naam(gebruikerDto.getNaam())
                .achternaam(gebruikerDto.getAchternaam())
                .rolType(gebruikerDto.getRolType())
                .geboorteDatum(gebruikerDto.getGeboorteDatum())
                .actief(gebruikerDto.isActief())
                .build();
    }

    public GebruikerDto convertToGebruikerDto(Gebruiker gebruiker){
        return new GebruikerDto
                .GebruikerDtoBuilder()
                .id(gebruiker.getId())
                .achternaam(gebruiker.getAchternaam())
                .naam(gebruiker.getNaam())
                .rolType(gebruiker.getRolType())
                .geboorteDatum(gebruiker.getGeboorteDatum())
                .actief(gebruiker.isActief())
                .build();
    }

    public List<Gebruiker> convertToGebruikerList(List<GebruikerDto> dtoList) {
        List<Gebruiker> gebruikerList = new ArrayList<>();

        for (GebruikerDto gebruikerDto: dtoList) {
            gebruikerList.add(convertToGebruiker(gebruikerDto));
        }

        return gebruikerList;
    }

    public List<GebruikerDto> convertToGebruikerDtoList(List<Gebruiker> list) {
        List<GebruikerDto> gebruikerList = new ArrayList<>();

        for (Gebruiker gebruiker: list) {
            gebruikerList.add(convertToGebruikerDto(gebruiker));
        }

        return gebruikerList;
    }
}
