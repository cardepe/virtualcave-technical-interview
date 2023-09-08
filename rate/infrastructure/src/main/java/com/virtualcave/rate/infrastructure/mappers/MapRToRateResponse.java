package com.virtualcave.rate.infrastructure.mappers;

import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.restapi.openapi.model.Rate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapRToRateResponse {

    Rate from(RateDto dto);

    List<Rate> from(List<RateDto> list);

}
