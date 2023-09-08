package com.virtualcave.rate.infrastructure.rest;

import com.virtualcave.rate.application.exceptions.RateForIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RateExceptionHandler {

    @ExceptionHandler(value = RateForIdNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handle(RateForIdNotFoundException ex) {
        return "Rate id " + ex.getId() + " not found";
    }
}
