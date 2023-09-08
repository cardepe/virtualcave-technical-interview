package com.virtualcave.rate.application.mappers;

import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapRToRateDto {

    RateDto from(RateEntity entity);

    List<RateDto> from(List<RateEntity> list);

}
