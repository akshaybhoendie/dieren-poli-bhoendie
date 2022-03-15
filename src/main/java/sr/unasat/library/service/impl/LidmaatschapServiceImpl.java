package sr.unasat.library.service.impl;

import sr.unasat.library.config.JPAConfiguration;
import sr.unasat.library.dto.LidMaatschapDto;
import sr.unasat.library.entity.Lidmaatschap;
import sr.unasat.library.mapper.LidmaatschapMapper;
import sr.unasat.library.mapper.impl.LidmaatschapMapperImpl;
import sr.unasat.library.repository.LidmaatschapRepository;
import sr.unasat.library.service.LidmaatschapService;

import java.util.List;

public class LidmaatschapServiceImpl implements LidmaatschapService {

    private final LidmaatschapRepository lidmaatschapRepository;
    private final LidmaatschapMapper lidmaatschapMapper;

    public LidmaatschapServiceImpl() {
        this.lidmaatschapRepository = new LidmaatschapRepository(JPAConfiguration.getEntityManager());
        this.lidmaatschapMapper = new LidmaatschapMapperImpl();
    }

    @Override
    public List<Lidmaatschap> activeLidmaatschappen() {
        return lidmaatschapRepository.getAllActiveLidmaatschappen();
    }

    @Override
    public LidMaatschapDto createLidmaatschap(LidMaatschapDto lidMaatschapDto) {
        Lidmaatschap lidmaatschap = lidmaatschapMapper.toEntity(lidMaatschapDto);
        return lidmaatschapMapper.toDto(lidmaatschapRepository.createLidmaatschap(lidmaatschap));
    }

    @Override
    public int deleteLidmatschap(Long lidmaatschapId) {
        return lidmaatschapRepository.deleteLidmaatschap(lidmaatschapId);
    }

    @Override
    public LidMaatschapDto updateLidmatschap(LidMaatschapDto lidMaatschapDto) {
        Lidmaatschap lidmaatschap = lidmaatschapMapper.toEntity(lidMaatschapDto);
        return lidmaatschapMapper.toDto(lidmaatschapRepository.updateLidmaatschap(lidmaatschap));
    }

    @Override
    public LidMaatschapDto findLidmatschapById(Long lidmaatschapId) {
        return lidmaatschapMapper.toDto(lidmaatschapRepository.findLidmaatschapById(lidmaatschapId));
    }
}
