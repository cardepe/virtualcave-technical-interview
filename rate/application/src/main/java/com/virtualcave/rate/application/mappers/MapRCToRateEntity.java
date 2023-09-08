package com.virtualcave.rate.application.mappers;

import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface MapRCToRateEntity {

    RateEntity from(RateCreateDto dto);

    default Mono<RateEntity> from(Mono<RateCreateDto> mono) {
        return mono.map(this::from);
    }

}
