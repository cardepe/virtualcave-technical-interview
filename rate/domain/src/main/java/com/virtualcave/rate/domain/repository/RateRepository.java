package com.virtualcave.rate.domain.repository;

import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.finder.RateByIdFinderDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;
import com.virtualcave.rate.domain.entity.RateEntity;

import java.util.List;
import java.util.Optional;

public interface RateRepository {

    List<RateEntity> list();

    Optional<RateEntity> find(RateByIdFinderDto finderDto);

    RateEntity create(RateCreateDto createDto);

    RateEntity update(RateUpdateDto updateDto);

    void delete(Integer id);

}
