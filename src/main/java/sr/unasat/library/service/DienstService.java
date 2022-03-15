package sr.unasat.library.service;

import sr.unasat.library.dto.DienstDto;

import java.util.List;

public interface DienstService {

    List<DienstDto> activeDiensten();

    DienstDto createDienst(DienstDto dienstDto);

    int deleteDienst(Long dienstId);

    DienstDto updateDienst(DienstDto dienstDto);

    DienstDto findDienstById(Long dienstId);
}
