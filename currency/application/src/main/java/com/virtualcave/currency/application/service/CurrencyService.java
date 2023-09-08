package com.virtualcave.currency.application.service;

import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.domain.dto.finder.CurrencyByCodeFinderDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface CurrencyService {

    Flux<CurrencyDto> list();

    Mono<Optional<CurrencyDto>> find(Mono<CurrencyByCodeFinderDto> finderDto);

    Mono<CurrencyDto> findOrNotFound(Mono<CurrencyByCodeFinderDto> finderDto);

}
