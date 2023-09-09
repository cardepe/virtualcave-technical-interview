package com.virtualcave.rate.infrastructure.rest.decorator;

import com.virtualcave.currency.application.service.CurrencyService;
import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.domain.dto.finder.CurrencyByCodeFinderDto;
import com.virtualcave.rate.restapi.openapi.model.Currency;
import com.virtualcave.rate.restapi.openapi.model.Rate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RateResponseDecorator {

    private final CurrencyService currencyService;

    public RateResponseDecorator(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public Rate decorate(Rate data) {

        final String currencyCode = data.getCurrency().getCode();

        if (StringUtils.isNoneBlank(currencyCode)) {

            final CurrencyByCodeFinderDto finderDto = new CurrencyByCodeFinderDto();
            finderDto.setCode(currencyCode);

            final Mono<CurrencyDto> currencyDto = this.currencyService.findOrNotFound(Mono.just(finderDto));

            final Mono<Currency> currencyResponse = currencyDto.flatMap(c -> {

                final Currency currency = new Currency();
                currency.setCode(c.getCode());
                currency.setSymbol(c.getSymbol());
                currency.setDecimals(c.getDecimals());

                return Mono.just(currency);
            });

            data.setCurrency(currencyResponse.block());
        }

        return data;
    }

}
