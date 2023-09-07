package com.virtualcave.rate.infrastructure.controller;

import com.virtualcave.rate.restapi.openapi.api.RatesV1Api;
import com.virtualcave.rate.restapi.openapi.model.Rate;
import com.virtualcave.rate.restapi.openapi.model.ReqCreateRate;
import com.virtualcave.rate.restapi.openapi.model.ReqUpdateRate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RateController implements RatesV1Api {

    @Override
    public ResponseEntity<List<Rate>> listRatesV1(LocalDate dateBetween, Integer brandId, Integer productId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Rate> findRateByIdV1(Integer rateId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Rate> createRateV1(ReqCreateRate reqCreateRate) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Rate> updateRateV1(Integer rateId, ReqUpdateRate reqUpdateRate) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> deleteRateV1(Integer rateId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
