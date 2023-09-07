package com.virtualcave.currency.application.exceptions;

import lombok.Getter;

import static java.lang.String.format;

@Getter
public class CurrencyForCodeNotFoundException extends RuntimeException {

    private final String code;

    public CurrencyForCodeNotFoundException(String code) {
        super(format("Currency code [%s] not found", code));
        this.code = code;
    }

}
