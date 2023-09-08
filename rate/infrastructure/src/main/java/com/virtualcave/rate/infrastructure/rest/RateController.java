package com.virtualcave.rate.infrastructure.rest;

import com.virtualcave.rate.application.service.RateService;
import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.finder.RateByIdFinderDto;
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

import java.time.LocalDate;
import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;

@RestController
public class RateController implements RatesV1Api {

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @Override
    public ResponseEntity<List<Rate>> listRatesV1(LocalDate dateBetween, Integer brandId, Integer productId) {

        final List<RateDto> list = this.rateService.list();

        final List<Rate> response = getMapper(MapRToRateResponse.class).from(list);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Rate> findRateByIdV1(Integer rateId) {

        final RateByIdFinderDto finderDto = new RateByIdFinderDto();
        finderDto.setId(rateId);

        final RateDto rateDto = this.rateService.findOrNotFound(finderDto);

        final Rate response = getMapper(MapRToRateResponse.class).from(rateDto);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Rate> createRateV1(ReqCreateRate reqCreateRate) {

        final RateCreateDto createDto = getMapper(MapRToRateCreateDto.class).from(reqCreateRate);

        final RateDto rateDto = this.rateService.create(createDto);

        final Rate response = getMapper(MapRToRateResponse.class).from(rateDto);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Rate> updateRateV1(Integer rateId, ReqUpdateRate reqUpdateRate) {

        final RateUpdateDto updateDto = getMapper(MapRToRateUpdateDto.class).from(reqUpdateRate);
        updateDto.setId(rateId);

        final RateDto rateDto = this.rateService.update(updateDto);

        final Rate response = getMapper(MapRToRateResponse.class).from(rateDto);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteRateV1(Integer rateId) {

        this.rateService.delete(rateId);

        return ResponseEntity.ok().build();
    }
}
