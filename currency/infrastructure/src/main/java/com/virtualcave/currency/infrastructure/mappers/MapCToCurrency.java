package com.virtualcave.currency.infrastructure.mappers;

import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.restapi.openapi.model.Currency;
import org.mapstruct.Mapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Mapper
public interface MapCToCurrency {

    Currency from(CurrencyDto dto);

    default Mono<Currency> from(Mono<CurrencyDto> mono) {
        return mono.map(this::from);
    }

    default Flux<Currency> from(Flux<CurrencyDto> flux) {
        return flux.map(this::from);
    }

}
