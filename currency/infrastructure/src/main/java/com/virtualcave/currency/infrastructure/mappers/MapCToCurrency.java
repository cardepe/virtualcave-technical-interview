package com.virtualcave.currency.infrastructure.mappers;

import com.virtualcave.currency.domain.dto.CurrencyDto;
import com.virtualcave.currency.restapi.openapi.model.Currency;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapCToCurrency {

    Currency from(CurrencyDto dto);

    List<Currency> from(List<CurrencyDto> list);

}
