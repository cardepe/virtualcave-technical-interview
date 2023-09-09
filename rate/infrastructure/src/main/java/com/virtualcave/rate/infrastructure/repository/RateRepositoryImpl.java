package com.virtualcave.rate.infrastructure.repository;

import com.virtualcave.rate.application.mappers.MapRCToRateEntity;
import com.virtualcave.rate.application.mappers.MapRUToRateEntity;
import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.filter.RateFilterDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import com.virtualcave.rate.domain.repository.RateRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.mapstruct.factory.Mappers.getMapper;

@Repository
public class RateRepositoryImpl implements RateRepository {

    private final RateRepositoryJpa rateRepositoryJpa;

    public RateRepositoryImpl(RateRepositoryJpa rateRepositoryJpa) {
        this.rateRepositoryJpa = rateRepositoryJpa;
    }

    @Override
    public Flux<RateEntity> list(Mono<RateFilterDto> filterDto) {
        return filterDto.flatMapMany(f -> this.rateRepositoryJpa.list(f.getBrandId(), f.getProductId(), f.getDate()));
    }

    @Override
    public Mono<Optional<RateEntity>> find(Integer id) {
        return this.rateRepositoryJpa.findById(id).map(Optional::of);
    }

    @Override
    public Mono<RateEntity> create(Mono<RateCreateDto> createDto) {

        final Mono<RateEntity> create = getMapper(MapRCToRateEntity.class).from(createDto);

        return create.flatMap(this.rateRepositoryJpa::save);
    }

    @Override
    public Mono<RateEntity> update(Mono<RateUpdateDto> updateDto) {

        final Mono<RateEntity> update = getMapper(MapRUToRateEntity.class).from(updateDto);

        return update.flatMap(this.rateRepositoryJpa::save);
    }

    @Override
    public void delete(Integer id) {
        this.rateRepositoryJpa.deleteById(id);
    }
}
