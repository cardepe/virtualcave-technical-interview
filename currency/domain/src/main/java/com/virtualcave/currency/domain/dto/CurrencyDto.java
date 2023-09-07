package com.virtualcave.currency.domain.dto;

import lombok.Data;

@Data
public class CurrencyDto {

    private String symbol;

    private String code;

    private Integer decimals;

}
