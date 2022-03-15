package sr.unasat.library.service;

import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.entity.Gebruiker;

import java.util.List;

public interface GebruikerService {

    List<Gebruiker> activeGebruikers();

    GebruikerDto createGebruiker(GebruikerDto gebruikerDto);

    int deleteGebruiker(Long gebruikerId);

    GebruikerDto updateGebruiker(GebruikerDto gebruikerDto);

    GebruikerDto findGebruikerById(Long gebruikerId);

}
