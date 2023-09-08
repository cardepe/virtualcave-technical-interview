package com.virtualcave.rate.domain.repository;

import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface RateRepository {

    Flux<RateEntity> list();

    Mono<Optional<RateEntity>> find(Integer id);

    Mono<RateEntity> create(Mono<RateCreateDto> createDto);

    Mono<RateEntity> update(Mono<RateUpdateDto> updateDto);

    void delete(Integer id);

}
