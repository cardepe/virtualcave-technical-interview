package com.virtualcave.rate.application.service;

import com.virtualcave.rate.application.exceptions.RateForIdNotFoundException;
import com.virtualcave.rate.application.mappers.MapRToRateDto;
import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.finder.RateByIdFinderDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import com.virtualcave.rate.domain.repository.RateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.mapstruct.factory.Mappers.getMapper;

@Service
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    public RateServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public List<RateDto> list() {

        final List<RateEntity> list = this.rateRepository.list();

        return getMapper(MapRToRateDto.class).from(list);
    }

    @Override
    public Optional<RateDto> find(RateByIdFinderDto finderDto) {

        final Optional<RateEntity> entity = this.rateRepository.find(finderDto);

        return entity.map(getMapper(MapRToRateDto.class)::from);
    }

    @Override
    public RateDto findOrNotFound(RateByIdFinderDto finderDto) {

        final Supplier<RuntimeException> notFound = () -> new RateForIdNotFoundException(finderDto.getId());

        return this.find(finderDto).orElseThrow(notFound);
    }

    @Override
    public RateDto create(RateCreateDto createDto) {

        final RateEntity entity = this.rateRepository.create(createDto);

        return getMapper(MapRToRateDto.class).from(entity);
    }

    @Override
    public RateDto update(RateUpdateDto updateDto) {

        final RateByIdFinderDto finderDto = new RateByIdFinderDto();
        finderDto.setId(updateDto.getId());

        this.findOrNotFound(finderDto);

        final RateEntity entity = this.rateRepository.update(updateDto);

        return getMapper(MapRToRateDto.class).from(entity);
    }

    @Override
    public void delete(Integer id) {

        final RateByIdFinderDto finderDto = new RateByIdFinderDto();
        finderDto.setId(id);

        this.findOrNotFound(finderDto);

        this.rateRepository.delete(id);
    }
}
