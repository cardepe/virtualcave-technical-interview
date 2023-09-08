package com.virtualcave.rate.infrastructure.repository;

import com.virtualcave.rate.domain.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepositoryJpa extends JpaRepository<RateEntity, Integer> {

}
