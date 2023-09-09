package com.virtualcave.rate.infrastructure.repository;

import com.virtualcave.rate.domain.entity.RateEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface RateRepositoryJpa extends ReactiveCrudRepository<RateEntity, Integer> {

    @Query("SELECT * FROM t_rates" +
            " WHERE (:brandId IS NULL OR brand_id = :brandId)" +
            " AND (:productId IS NULL OR product_id = :productId)" +
            " AND (:date IS NULL OR (:date BETWEEN start_date AND end_date))")
    Flux<RateEntity> list(Integer brandId, Integer productId, LocalDate date);

}
