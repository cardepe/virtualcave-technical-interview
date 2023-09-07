package com.virtualcave.currency.infrastructure.rest;

import com.virtualcave.currency.application.service.CurrencyService;
import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.domain.dto.finder.CurrencyByCodeFinderDto;
import com.virtualcave.currency.infrastructure.mappers.MapCToCurrency;
import com.virtualcave.currency.restapi.openapi.api.CurrenciesApi;
import com.virtualcave.currency.restapi.openapi.model.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;

@RestController
public class CurrencyController implements CurrenciesApi {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public ResponseEntity<List<Currency>> getCurrencies() {

        final List<CurrencyDto> list = this.currencyService.list();

        final List<Currency> currencies = getMapper(MapCToCurrency.class).from(list);

        return ResponseEntity.ok(currencies);
    }

    @Override
    public ResponseEntity<Currency> getCurrencyByCode(String currencyCode) {

        final CurrencyByCodeFinderDto finderDto = new CurrencyByCodeFinderDto();
        finderDto.setCode(currencyCode);

        final CurrencyDto found = this.currencyService.findOrNotFound(finderDto);

        final Currency currency = getMapper(MapCToCurrency.class).from(found);

        return ResponseEntity.ok(currency);
    }

}
