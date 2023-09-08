package com.virtualcave.rate.infrastructure.mappers;

import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.restapi.openapi.model.ReqUpdateRate;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface MapRToRateUpdateDto {

    RateUpdateDto from(ReqUpdateRate req);

    default Mono<RateUpdateDto> from(Mono<ReqUpdateRate> mono) {
        return mono.map(this::from);
    }

}
