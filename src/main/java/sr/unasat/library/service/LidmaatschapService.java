package sr.unasat.library.service;

import sr.unasat.library.dto.LidMaatschapDto;
import sr.unasat.library.entity.Lidmaatschap;

import java.util.List;

public interface LidmaatschapService {

    List<Lidmaatschap> activeLidmaatschappen();

    LidMaatschapDto createLidmaatschap(LidMaatschapDto lidMaatschapDto);

    int deleteLidmatschap(Long lidmaatschapId);

    LidMaatschapDto updateLidmatschap(LidMaatschapDto lidMaatschapDto);

    LidMaatschapDto findLidmatschapById(Long lidmaatschapId);

}
