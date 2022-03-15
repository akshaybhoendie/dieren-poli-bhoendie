package sr.unasat.library.mapper.adapter;

import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.entity.Gebruiker;
import sr.unasat.library.mapper.GebruikerMapper;

import java.util.List;

public class GebruikerAdapter implements GebruikerMapper {

    private final GebruikerConverterAdaptee gebruikerConverterAdaptee;

    public GebruikerAdapter(GebruikerConverterAdaptee converterAdaptee){
        this.gebruikerConverterAdaptee = converterAdaptee;
    }

    @Override
    public Gebruiker gebruikerDtoToGebruiker(GebruikerDto gebruikerDto) {
        return gebruikerConverterAdaptee.convertToGebruiker(gebruikerDto);
    }

    @Override
    public GebruikerDto gebruikerToGebruikerDto(Gebruiker gebruiker) {
        return gebruikerConverterAdaptee.convertToGebruikerDto(gebruiker);
    }

    @Override
    public List<Gebruiker> gebruikerDtoListToGebruikerList(List<GebruikerDto> dtoList) {
        return gebruikerConverterAdaptee.convertToGebruikerList(dtoList);
    }

    @Override
    public List<GebruikerDto> gebruikerListToGebruikerDtoList(List<Gebruiker> list) {
        return gebruikerConverterAdaptee.convertToGebruikerDtoList(list);
    }
}
