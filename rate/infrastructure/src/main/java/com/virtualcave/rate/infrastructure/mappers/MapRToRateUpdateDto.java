package com.virtualcave.rate.infrastructure.mappers;

import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.restapi.openapi.model.ReqUpdateRate;
import org.mapstruct.Mapper;

@Mapper
public interface MapRToRateUpdateDto {

    RateUpdateDto from(ReqUpdateRate req);

}
