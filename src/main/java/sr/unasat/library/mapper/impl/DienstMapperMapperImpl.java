package sr.unasat.library.mapper.impl;

import sr.unasat.library.dto.DienstDto;
import sr.unasat.library.entity.Dienst;
import sr.unasat.library.mapper.DienstMapper;

import java.util.ArrayList;
import java.util.List;

public class DienstMapperMapperImpl implements DienstMapper {


    @Override
    public Dienst toEntity(DienstDto dto) {
        Dienst dienst = new Dienst();
        dienst.setId(dto.getId());
        dienst.setDienstType(dto.getDienstType());
        dienst.setLidmaatschap(dto.getLidmaatschap());
        dienst.setAangemaaktDoor(dto.getAangemaaktDoor());
        dienst.setAfgehandeldDoor(dto.getAfgehanldDoor());
        dienst.setDatum(dto.getDatum());
        dienst.setOpmerking(dto.getOpmerking());
        dienst.setActief(dto.isActief());

        return dienst;
    }

    @Override
    public DienstDto toDto(Dienst dienst) {
        DienstDto dienstDto = new DienstDto();
        dienstDto.setId(dienst.getId());
        dienstDto.setDienstType(dienst.getDienstType());
        dienstDto.setLidmaatschap(dienst.getLidmaatschap());
        dienstDto.setAangemaaktDoor(dienst.getAangemaaktDoor());
        dienstDto.setAfgehanldDoor(dienst.getAfgehandeldDoor());
        dienstDto.setDatum(dienst.getDatum());
        dienstDto.setOpmerking(dienst.getOpmerking());
        dienstDto.setActief(dienst.isActief());

        return dienstDto;
    }

    @Override
    public List<Dienst> toEntityList(List<DienstDto> dtoList) {
        List<Dienst> dienstList = new ArrayList<>();

        for (DienstDto dienstDto : dtoList) {
            dienstList.add(toEntity(dienstDto));
        }

        return dienstList;
    }

    @Override
    public List<DienstDto> toDtoList(List<Dienst> list) {
        List<DienstDto> dienstDtoList = new ArrayList<>();

        for (Dienst dienst : list) {
            dienstDtoList.add(toDto(dienst));
        }

        return dienstDtoList;
    }
}
