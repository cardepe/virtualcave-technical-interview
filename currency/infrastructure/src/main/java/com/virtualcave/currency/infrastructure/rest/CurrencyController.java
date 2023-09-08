package com.virtualcave.currency.infrastructure.rest;

import com.virtualcave.currency.application.service.CurrencyService;
import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.domain.dto.finder.CurrencyByCodeFinderDto;
import com.virtualcave.currency.infrastructure.mappers.MapCToCurrency;
import com.virtualcave.currency.restapi.openapi.api.CurrenciesApi;
import com.virtualcave.currency.restapi.openapi.model.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mapstruct.factory.Mappers.getMapper;

@RestController
public class CurrencyController implements CurrenciesApi {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public Mono<ResponseEntity<Flux<Currency>>> getCurrencies(ServerWebExchange exchange) {

        final Flux<CurrencyDto> list = this.currencyService.list();

        final Flux<Currency> currencies = getMapper(MapCToCurrency.class).from(list);

        return Mono.just(ResponseEntity.ok(currencies));
    }

    @Override
    public Mono<ResponseEntity<Currency>> getCurrencyByCode(String currencyCode, ServerWebExchange exchange) {

        final CurrencyByCodeFinderDto finderDto = new CurrencyByCodeFinderDto();
        finderDto.setCode(currencyCode);

        final Mono<CurrencyDto> found = this.currencyService.findOrNotFound(Mono.just(finderDto));

        final Mono<Currency> currency = getMapper(MapCToCurrency.class).from(found);

        return currency.map(ResponseEntity::ok);
    }

}
