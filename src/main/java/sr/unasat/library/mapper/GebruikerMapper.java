package sr.unasat.library.mapper;

import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.entity.Gebruiker;

import java.util.List;

public interface GebruikerMapper {

    Gebruiker gebruikerDtoToGebruiker(GebruikerDto gebruikerDto);

    GebruikerDto gebruikerToGebruikerDto(Gebruiker gebruiker);

    List<Gebruiker> gebruikerDtoListToGebruikerList(List<GebruikerDto> dtoList);

    List<GebruikerDto> gebruikerListToGebruikerDtoList(List<Gebruiker> list);
}
