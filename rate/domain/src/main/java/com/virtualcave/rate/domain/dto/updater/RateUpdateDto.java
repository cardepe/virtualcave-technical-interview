package com.virtualcave.rate.domain.dto.updater;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RateUpdateDto {

    private Integer id;

    private Integer brandId;

    private Integer productId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer price;

    private String currencyCode;

}
