package com.virtualcave.rate.application.service;

import com.virtualcave.rate.application.exceptions.RateForIdNotFoundException;
import com.virtualcave.rate.application.mappers.MapRToRateDto;
import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import com.virtualcave.rate.domain.repository.RateRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<RateDto> list() {

        final Flux<RateEntity> list = this.rateRepository.list();

        return getMapper(MapRToRateDto.class).from(list);
    }

    @Override
    public Mono<Optional<RateDto>> find(Integer id) {

        final Mono<Optional<RateEntity>> entity = this.rateRepository.find(id);

        return entity.switchIfEmpty(Mono.just(Optional.empty())).map(o -> o.map(getMapper(MapRToRateDto.class)::from));
    }

    @Override
    public Mono<RateDto> findOrNotFound(Integer id) {

        final Supplier<RuntimeException> notFound = () -> new RateForIdNotFoundException(id);

        return this.find(id).flatMap(optional -> optional.map(Mono::just).orElseThrow(notFound));
    }

    @Override
    public Mono<RateDto> create(Mono<RateCreateDto> createDto) {

        final Mono<RateEntity> entity = this.rateRepository.create(createDto);

        return getMapper(MapRToRateDto.class).from(entity);
    }

    @Override
    public Mono<RateDto> update(Integer id, Mono<RateUpdateDto> updateDto) {

        this.findOrNotFound(id);

        final Mono<RateEntity> entity = this.rateRepository.update(updateDto);

        return getMapper(MapRToRateDto.class).from(entity);
    }

    @Override
    public void delete(Integer id) {

        this.findOrNotFound(id);

        this.rateRepository.delete(id);
    }
}
