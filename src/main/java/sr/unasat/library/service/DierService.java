package sr.unasat.library.service;

import sr.unasat.library.dto.DierDto;

import java.util.List;

public interface DierService {

    List<DierDto> getAllDieren();

    DierDto createDier(DierDto dierDto);

    int deleteDier(Long dierId);

    DierDto updateDier(DierDto dierDto);

    DierDto findDierById(Long dierId);

    List<DierDto> findDierenOfOwnerByOwnerId(Long ownerId);
}
