package com.virtualcave.rate.application.mappers;

import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface MapRUToRateEntity {
    
    RateEntity from(RateUpdateDto dto);

    default Mono<RateEntity> from(Mono<RateUpdateDto> mono) {
        return mono.map(this::from);
    }

}
