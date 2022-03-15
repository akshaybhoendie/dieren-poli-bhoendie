package sr.unasat.library.service.impl;

import sr.unasat.library.config.JPAConfiguration;
import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.entity.Gebruiker;
import sr.unasat.library.mapper.adapter.GebruikerAdapter;
import sr.unasat.library.mapper.adapter.GebruikerConverterAdaptee;
import sr.unasat.library.repository.GebruikerRepository;
import sr.unasat.library.service.GebruikerService;

import java.util.List;

public class GebruikerServiceImpl implements GebruikerService {

    private final GebruikerRepository gebruikerRepository;
    private final GebruikerAdapter gebruikerAdapter;

    public GebruikerServiceImpl() {
        this.gebruikerRepository = new GebruikerRepository(JPAConfiguration.getEntityManager());
        this.gebruikerAdapter = new GebruikerAdapter(new GebruikerConverterAdaptee());
    }

    @Override
    public List<Gebruiker> activeGebruikers() {
        return gebruikerRepository.getAllActiveUsers();
    }

    public GebruikerDto createGebruiker(GebruikerDto gebruikerDto){
        Gebruiker gebruiker = gebruikerAdapter.gebruikerDtoToGebruiker(gebruikerDto);
        return gebruikerAdapter.gebruikerToGebruikerDto(gebruikerRepository.createGebruiker(gebruiker));
    }

    public int deleteGebruiker(Long gebruikerId){
        return gebruikerRepository.deleteGebruiker(gebruikerId);
    }

    public GebruikerDto updateGebruiker(GebruikerDto gebruikerDto){
        Gebruiker gebruiker = gebruikerAdapter.gebruikerDtoToGebruiker(gebruikerDto);
        return gebruikerAdapter.gebruikerToGebruikerDto(gebruikerRepository.updateGebruiker(gebruiker));
    }

    public GebruikerDto findGebruikerById(Long gebruikerId){
        return gebruikerAdapter.gebruikerToGebruikerDto(gebruikerRepository.findGebruikerById(gebruikerId));
    }

}
