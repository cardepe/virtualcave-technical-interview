package com.virtualcave.rate.infrastructure.mappers;

import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.restapi.openapi.model.ReqCreateRate;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface MapRToRateCreateDto {

    RateCreateDto from(ReqCreateRate req);

    default Mono<RateCreateDto> from(Mono<ReqCreateRate> mono) {
        return mono.map(this::from);
    }

}
