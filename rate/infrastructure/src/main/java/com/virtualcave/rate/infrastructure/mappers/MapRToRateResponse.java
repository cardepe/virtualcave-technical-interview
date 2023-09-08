package com.virtualcave.rate.infrastructure.mappers;

import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.restapi.openapi.model.Rate;
import org.mapstruct.Mapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Mapper
public interface MapRToRateResponse {

    Rate from(RateDto dto);

    default Mono<Rate> from(Mono<RateDto> mono) {
        return mono.map(this::from);
    }

    default Flux<Rate> from(Flux<RateDto> flux) {
        return flux.map(this::from);
    }

}
