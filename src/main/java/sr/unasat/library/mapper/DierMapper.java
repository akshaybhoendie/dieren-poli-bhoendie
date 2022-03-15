package sr.unasat.library.mapper;

import sr.unasat.library.dto.DierDto;
import sr.unasat.library.entity.Dier;

import java.util.List;

public interface DierMapper {

    Dier toEntity(DierDto dto);

    DierDto toDto(Dier dier);

    List<Dier> toEntityList(List<DierDto> dtoList);

    List<DierDto> toDtoList(List<Dier> list);
}
