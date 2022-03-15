package sr.unasat.library.service.impl;

import sr.unasat.library.config.JPAConfiguration;
import sr.unasat.library.dto.DienstDto;
import sr.unasat.library.mapper.DienstMapper;
import sr.unasat.library.mapper.LidmaatschapMapper;
import sr.unasat.library.mapper.impl.DienstMapperMapperImpl;
import sr.unasat.library.mapper.impl.LidmaatschapMapperImpl;
import sr.unasat.library.repository.DienstRepository;
import sr.unasat.library.repository.LidmaatschapRepository;
import sr.unasat.library.service.DienstService;

import java.util.List;

public class DienstServiceImpl implements DienstService {
    private final DienstRepository dienstRepository;
    private final DienstMapper dienstMapper;

    public DienstServiceImpl() {
        this.dienstRepository = new DienstRepository(JPAConfiguration.getEntityManager());
        this.dienstMapper = new DienstMapperMapperImpl();
    }


    @Override
    public List<DienstDto> activeDiensten() {
        return dienstMapper.toDtoList(dienstRepository.getAllActiveDiensten());
    }

    @Override
    public DienstDto createDienst(DienstDto dienstDto) {
        return dienstMapper.toDto(dienstRepository.createDienst(dienstMapper.toEntity(dienstDto)));
    }

    @Override
    public int deleteDienst(Long dienstId) {
        return dienstRepository.deleteDienst(dienstId);
    }

    @Override
    public DienstDto updateDienst(DienstDto dienstDto) {
        return dienstMapper.toDto(dienstRepository.updateDienst(dienstMapper.toEntity(dienstDto)));
    }

    @Override
    public DienstDto findDienstById(Long dienstId) {
        return dienstMapper.toDto(dienstRepository.findDienstById(dienstId));
    }
}
