package sr.unasat.library.mapper;

import sr.unasat.library.dto.GebruikerDto;
import sr.unasat.library.dto.LidMaatschapDto;
import sr.unasat.library.entity.Gebruiker;
import sr.unasat.library.entity.Lidmaatschap;

import java.util.List;

public interface LidmaatschapMapper {

    Lidmaatschap toEntity(LidMaatschapDto dto);

    LidMaatschapDto toDto(Lidmaatschap lidmaatschap);

    List<Lidmaatschap> toEntityList(List<LidMaatschapDto> dtoList);

    List<LidMaatschapDto> toDtoList(List<Lidmaatschap> list);
}
