package com.virtualcave.currency.application.service;

import com.virtualcave.currency.application.exceptions.CurrencyForCodeNotFoundException;
import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.domain.dto.finder.CurrencyByCodeFinderDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public Flux<CurrencyDto> list() {
        return Flux.fromIterable(this.buildCurrencyList());
    }

    @Override
    public Mono<Optional<CurrencyDto>> find(Mono<CurrencyByCodeFinderDto> finderDto) {
        return Mono.just(this.buildCurrencyList().stream().filter(c -> Objects.requireNonNull(finderDto.block()).getCode().equals(c.getCode())).findAny());
    }

    @Override
    public Mono<CurrencyDto> findOrNotFound(Mono<CurrencyByCodeFinderDto> finderDto) {

        final Supplier<RuntimeException> notFound = () -> new CurrencyForCodeNotFoundException(Objects.requireNonNull(finderDto.block()).getCode());

        return this.find(finderDto).flatMap(optional -> optional.map(Mono::just).orElseThrow(notFound));
    }

    private List<CurrencyDto> buildCurrencyList() {

        final CurrencyDto eurCurrencyDto = new CurrencyDto();
        eurCurrencyDto.setSymbol("€");
        eurCurrencyDto.setCode("EUR");
        eurCurrencyDto.setDecimals(2);

        final CurrencyDto usdCurrencyDto = new CurrencyDto();
        usdCurrencyDto.setSymbol("$");
        usdCurrencyDto.setCode("USD");
        usdCurrencyDto.setDecimals(2);

        return List.of(eurCurrencyDto, usdCurrencyDto);
    }
}
