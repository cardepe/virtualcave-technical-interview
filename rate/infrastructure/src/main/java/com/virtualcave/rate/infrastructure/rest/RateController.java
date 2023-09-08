package com.virtualcave.rate.infrastructure.rest;

import com.virtualcave.rate.application.service.RateService;
import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.infrastructure.mappers.MapRToRateCreateDto;
import com.virtualcave.rate.infrastructure.mappers.MapRToRateResponse;
import com.virtualcave.rate.infrastructure.mappers.MapRToRateUpdateDto;
import com.virtualcave.rate.restapi.openapi.api.RatesV1Api;
import com.virtualcave.rate.restapi.openapi.model.Rate;
import com.virtualcave.rate.restapi.openapi.model.ReqCreateRate;
import com.virtualcave.rate.restapi.openapi.model.ReqUpdateRate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.mapstruct.factory.Mappers.getMapper;

@RestController
public class RateController implements RatesV1Api {

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @Override
    public Mono<ResponseEntity<Flux<Rate>>> listRatesV1(LocalDate dateBetween, Integer brandId, Integer productId, ServerWebExchange exchange) {

        final Flux<RateDto> list = this.rateService.list();

        final Flux<Rate> response = getMapper(MapRToRateResponse.class).from(list);

        return Mono.just(ResponseEntity.ok(response));
    }

    @Override
    public Mono<ResponseEntity<Rate>> findRateByIdV1(Integer rateId, ServerWebExchange exchange) {

        return this.rateService.findOrNotFound(rateId)
                .map(r -> getMapper(MapRToRateResponse.class).from(r))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Rate>> createRateV1(Mono<ReqCreateRate> reqCreateRate, ServerWebExchange exchange) {

        final Mono<RateCreateDto> createDto = getMapper(MapRToRateCreateDto.class).from(reqCreateRate);

        return this.rateService.create(createDto)
                .map(r -> getMapper(MapRToRateResponse.class).from(r))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Rate>> updateRateV1(Integer rateId, Mono<ReqUpdateRate> reqUpdateRate, ServerWebExchange exchange) {

        final Mono<RateUpdateDto> updateDto = getMapper(MapRToRateUpdateDto.class).from(reqUpdateRate)
                .map(r -> { r.setId(rateId); return r; });

        return this.rateService.update(rateId, updateDto)
                .map(r -> getMapper(MapRToRateResponse.class).from(r))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteRateV1(Integer rateId, ServerWebExchange exchange) {

        this.rateService.delete(rateId);

        return Mono.just(ResponseEntity.ok().build());
    }
}
