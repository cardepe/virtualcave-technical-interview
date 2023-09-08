package com.virtualcave.rate.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RateDto {

    private Integer id;

    private Integer brandId;

    private Integer productId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer price;

    private String currencyCode;

}
