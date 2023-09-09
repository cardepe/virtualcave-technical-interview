package com.virtualcave.rate.application.service;

import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.filter.RateFilterDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface RateService {

    Flux<RateDto> list(Mono<RateFilterDto> filterDto);

    Mono<Optional<RateDto>> find(Integer id);

    Mono<RateDto> findOrNotFound(Integer id);

    Mono<RateDto> create(Mono<RateCreateDto> createDto);

    Mono<RateDto> update(Integer id, Mono<RateUpdateDto> createDto);

    void delete(Integer id);

}
