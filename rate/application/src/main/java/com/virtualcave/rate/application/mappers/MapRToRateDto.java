package com.virtualcave.rate.application.mappers;

import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.entity.RateEntity;
import org.mapstruct.Mapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Mapper
public interface MapRToRateDto {

    RateDto from(RateEntity entity);

    default Mono<RateDto> from(Mono<RateEntity> mono) {
        return mono.map(this::from);
    }

    default Flux<RateDto> from(Flux<RateEntity> flux) {
        return flux.map(this::from);
    }

}
