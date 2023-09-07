package com.virtualcave.currency.application.service;

import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.domain.dto.finder.CurrencyByCodeFinderDto;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

    List<CurrencyDto> list();

    Optional<CurrencyDto> find(CurrencyByCodeFinderDto finderDto);

    CurrencyDto findOrNotFound(CurrencyByCodeFinderDto finderDto);

}
