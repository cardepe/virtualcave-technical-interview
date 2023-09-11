/*
package com.virtualcave.rate.infrastructure.rest;

import com.virtualcave.rate.application.service.RateService;
import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.dto.filter.RateFilterDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(RateController.class)
public class RateControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Mock
    private RateService rateService;

    @Test
    void listRatesV1() {

        final RateFilterDto filterDto = new RateFilterDto();

        final RateDto rateDto = new RateDto();

        when(this.rateService.list(Mono.just(filterDto))).thenReturn(Flux.just(rateDto));

        webTestClient.get().uri("/v1/rates")
                .exchange()
                .expectStatus().isEqualTo(200)
                .expectBody()
                .json("");
    }
}
*/
