package com.virtualcave.rate.domain.dto.creator;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RateCreateDto {

    private Integer brandId;

    private Integer productId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer price;

    private String currencyCode;

}
