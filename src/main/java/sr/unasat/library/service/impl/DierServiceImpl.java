package sr.unasat.library.service.impl;

import sr.unasat.library.config.JPAConfiguration;
import sr.unasat.library.dto.DierDto;
import sr.unasat.library.mapper.DierMapper;
import sr.unasat.library.mapper.LidmaatschapMapper;
import sr.unasat.library.mapper.impl.DierMapperImpl;
import sr.unasat.library.mapper.impl.LidmaatschapMapperImpl;
import sr.unasat.library.repository.DierRepository;
import sr.unasat.library.repository.LidmaatschapRepository;
import sr.unasat.library.service.DierService;

import java.util.List;

public class DierServiceImpl implements DierService {

    private final DierRepository dierRepository;
    private final DierMapper dierMapper;

    public DierServiceImpl() {
        this.dierRepository = new DierRepository(JPAConfiguration.getEntityManager());
        this.dierMapper = new DierMapperImpl();
    }

    @Override
    public List<DierDto> getAllDieren() {
        return dierMapper.toDtoList(dierRepository.getAllDieren());
    }

    @Override
    public DierDto createDier(DierDto dierDto) {
        return dierMapper.toDto(dierRepository.createDier(dierMapper.toEntity(dierDto)));
    }

    @Override
    public int deleteDier(Long dierId) {
        return dierRepository.deleteDier(dierId);
    }

    @Override
    public DierDto updateDier(DierDto dierDto) {
        return dierMapper.toDto(dierRepository.updateDier(dierMapper.toEntity(dierDto)));
    }

    @Override
    public DierDto findDierById(Long dierId) {
        return dierMapper.toDto(dierRepository.findDierById(dierId));
    }

    @Override
    public List<DierDto> findDierenOfOwnerByOwnerId(Long ownerId) {
        return dierMapper.toDtoList(dierRepository.findDierenOfOwnerByOwnerId(ownerId));
    }
}
