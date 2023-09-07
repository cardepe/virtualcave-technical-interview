package com.virtualcave.currency.application.service;

import com.virtualcave.currency.application.exceptions.CurrencyForCodeNotFoundException;
import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.domain.dto.finder.CurrencyByCodeFinderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public List<CurrencyDto> list() {
        return this.buildCurrencyList();
    }

    @Override
    public Optional<CurrencyDto> find(CurrencyByCodeFinderDto finderDto) {
        return this.buildCurrencyList().stream().filter(c -> finderDto.getCode().equals(c.getCode())).findAny();
    }

    @Override
    public CurrencyDto findOrNotFound(CurrencyByCodeFinderDto finderDto) {

        final Supplier<RuntimeException> notFound = () -> new CurrencyForCodeNotFoundException(finderDto.getCode());

        return this.find(finderDto).orElseThrow(notFound);
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
