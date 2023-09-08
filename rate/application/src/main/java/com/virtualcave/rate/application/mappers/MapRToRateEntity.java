package com.virtualcave.rate.application.mappers;

import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MapRToRateEntity {

    RateEntity from(RateCreateDto dto);

    RateEntity from(RateUpdateDto dto);

}
