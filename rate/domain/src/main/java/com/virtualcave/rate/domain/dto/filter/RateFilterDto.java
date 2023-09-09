package com.virtualcave.rate.domain.dto.filter;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RateFilterDto {

    private Integer brandId;

    private Integer productId;

    private LocalDate date;

}
