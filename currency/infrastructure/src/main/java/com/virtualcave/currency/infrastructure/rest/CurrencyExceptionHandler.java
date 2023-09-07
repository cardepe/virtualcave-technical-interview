package com.virtualcave.currency.infrastructure.rest;

import com.virtualcave.currency.application.exceptions.CurrencyForCodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CurrencyExceptionHandler {

    @ExceptionHandler(value = CurrencyForCodeNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handle(CurrencyForCodeNotFoundException ex) {
        return "Currency code " + ex.getCode() + " not found";
    }
}
