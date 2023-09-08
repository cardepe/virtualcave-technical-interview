package com.virtualcave.rate.application.exceptions;

import lombok.Getter;

import static java.lang.String.format;

@Getter
public class RateForIdNotFoundException extends RuntimeException {

    private final Integer id;

    public RateForIdNotFoundException(Integer id) {
        super(format("Rate id [%s] not found", id));
        this.id = id;
    }

}
