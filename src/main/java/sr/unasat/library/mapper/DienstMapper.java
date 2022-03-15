package sr.unasat.library.mapper;

import sr.unasat.library.dto.DienstDto;
import sr.unasat.library.entity.Dienst;

import java.util.List;

public interface DienstMapper {

    Dienst toEntity(DienstDto dto);

    DienstDto toDto(Dienst dienst);

    List<Dienst> toEntityList(List<DienstDto> dtoList);

    List<DienstDto> toDtoList(List<Dienst> list);
}
