package sr.unasat.library.mapper.impl;

import sr.unasat.library.dto.DierDto;
import sr.unasat.library.dto.LidMaatschapDto;
import sr.unasat.library.entity.Dier;
import sr.unasat.library.entity.Dier;
import sr.unasat.library.entity.Lidmaatschap;
import sr.unasat.library.mapper.DierMapper;

import java.util.ArrayList;
import java.util.List;

public class DierMapperImpl implements DierMapper {


    @Override
    public Dier toEntity(DierDto dto) {
        Dier dier = new Dier();
        dier.setId(dto.getId());
        dier.setNaam(dto.getNaam());
        dier.setGewicht(dto.getGewicht());
        dier.setCategorie(dto.getCategorie());
        dier.setGeboordeDatum(dto.getGeboordeDatum());
        dier.setLidmaatschap(dto.getLidmaatschap());
        dier.setOverleden(dto.getOverleden());
        dier.setSoort(dto.getSoort());

        return dier;
    }

    @Override
    public DierDto toDto(Dier dier) {
        DierDto dierDto = new DierDto();
        dierDto.setId(dier.getId());
        dierDto.setNaam(dier.getNaam());
        dierDto.setGewicht(dier.getGewicht());
        dierDto.setCategorie(dier.getCategorie());
        dierDto.setGeboordeDatum(dier.getGeboordeDatum());
        dierDto.setLidmaatschap(dier.getLidmaatschap());
        dierDto.setOverleden(dier.getOverleden());
        dierDto.setSoort(dier.getSoort());

        return dierDto;
    }

    @Override
    public List<Dier> toEntityList(List<DierDto> dtoList) {
        List<Dier> list = new ArrayList<>();

        for (DierDto dierDto : dtoList) {
            list.add(toEntity(dierDto));
        }

        return list;
    }

    @Override
    public List<DierDto> toDtoList(List<Dier> list) {
        List<DierDto> dierDtoList = new ArrayList<>();

        for (Dier dier : list) {
            dierDtoList.add(toDto(dier));
        }

        return dierDtoList;
    }
}
