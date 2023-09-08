package com.virtualcave.rate.infrastructure.repository;

import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.finder.RateByIdFinderDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import com.virtualcave.rate.domain.repository.RateRepository;
import com.virtualcave.rate.application.mappers.MapRToRateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.mapstruct.factory.Mappers.getMapper;

@Repository
public class RateRepositoryImpl implements RateRepository {

    private final RateRepositoryJpa rateRepositoryJpa;

    public RateRepositoryImpl(RateRepositoryJpa rateRepositoryJpa) {
        this.rateRepositoryJpa = rateRepositoryJpa;
    }

    @Override
    public List<RateEntity> list() {
        return this.rateRepositoryJpa.findAll();
    }

    @Override
    public Optional<RateEntity> find(RateByIdFinderDto finderDto) {
        return this.rateRepositoryJpa.findById(finderDto.getId());
    }

    @Override
    public RateEntity create(RateCreateDto createDto) {

        final RateEntity create = getMapper(MapRToRateEntity.class).from(createDto);

        return this.rateRepositoryJpa.save(create);
    }

    @Override
    public RateEntity update(RateUpdateDto updateDto) {

        final RateEntity update = getMapper(MapRToRateEntity.class).from(updateDto);

        return this.rateRepositoryJpa.save(update);
    }

    @Override
    public void delete(Integer id) {
        this.rateRepositoryJpa.deleteById(id);
    }
}
