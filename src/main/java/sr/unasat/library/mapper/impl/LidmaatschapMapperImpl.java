package sr.unasat.library.mapper.impl;

import sr.unasat.library.dto.LidMaatschapDto;
import sr.unasat.library.entity.Lidmaatschap;
import sr.unasat.library.mapper.LidmaatschapMapper;

import java.util.ArrayList;
import java.util.List;

public class LidmaatschapMapperImpl implements LidmaatschapMapper {


    @Override
    public Lidmaatschap toEntity(LidMaatschapDto dto) {
        Lidmaatschap lidmaatschap = new Lidmaatschap();
        lidmaatschap.setId(dto.getId());
        lidmaatschap.setVoornaam(dto.getVoornaam());
        lidmaatschap.setAchternaam(dto.getAchternaam());
        lidmaatschap.setLidmaatschapNummer(dto.getLidmaatschapNummer());
        lidmaatschap.setGebruiker(dto.getGebruiker());
        lidmaatschap.setDieren(dto.getDieren());
        lidmaatschap.setGeboorteDatum(dto.getGeboorteDatum());
        lidmaatschap.setInschrijfDatum(dto.getInschrijfDatum());

        return lidmaatschap;
    }

    @Override
    public LidMaatschapDto toDto(Lidmaatschap lidmaatschap) {
       LidMaatschapDto lidMaatschapDto = new LidMaatschapDto();
        lidMaatschapDto.setId(lidmaatschap.getId());
        lidMaatschapDto.setVoornaam(lidmaatschap.getVoornaam());
        lidMaatschapDto.setAchternaam(lidmaatschap.getAchternaam());
        lidMaatschapDto.setLidmaatschapNummer(lidmaatschap.getLidmaatschapNummer());
        lidMaatschapDto.setGebruiker(lidmaatschap.getGebruiker());
        lidMaatschapDto.setDieren(lidmaatschap.getDieren());
        lidMaatschapDto.setGeboorteDatum(lidmaatschap.getGeboorteDatum());
        lidMaatschapDto.setInschrijfDatum(lidmaatschap.getInschrijfDatum());

        return lidMaatschapDto;
    }

    @Override
    public List<Lidmaatschap> toEntityList(List<LidMaatschapDto> dtoList) {
         List<Lidmaatschap> lidmaatschapList = new ArrayList<>();

        for (LidMaatschapDto lidmaatschapDto : dtoList) {
            lidmaatschapList.add(toEntity(lidmaatschapDto));
        }

        return lidmaatschapList;
    }

    @Override
    public List<LidMaatschapDto> toDtoList(List<Lidmaatschap> list) {
        List<LidMaatschapDto> lidmaatschapList = new ArrayList<>();

        for (Lidmaatschap lidmaatschap : list) {
            lidmaatschapList.add(toDto(lidmaatschap));
        }

        return lidmaatschapList;
    }
}
