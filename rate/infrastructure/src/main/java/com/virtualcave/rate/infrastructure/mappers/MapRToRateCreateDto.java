package com.virtualcave.rate.infrastructure.mappers;

import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.restapi.openapi.model.ReqCreateRate;
import org.mapstruct.Mapper;

@Mapper
public interface MapRToRateCreateDto {

    RateCreateDto from(ReqCreateRate req);

}
