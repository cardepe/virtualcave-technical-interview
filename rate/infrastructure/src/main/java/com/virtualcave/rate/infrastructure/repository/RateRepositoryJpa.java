package com.virtualcave.rate.infrastructure.repository;

import com.virtualcave.rate.domain.entity.RateEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepositoryJpa extends ReactiveCrudRepository<RateEntity, Integer> {

}
