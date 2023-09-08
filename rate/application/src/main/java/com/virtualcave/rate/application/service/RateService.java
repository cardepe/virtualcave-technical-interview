package com.virtualcave.rate.application.service;

import com.virtualcave.rate.domain.dto.RateDto;
import com.virtualcave.rate.domain.dto.creator.RateCreateDto;
import com.virtualcave.rate.domain.dto.finder.RateByIdFinderDto;
import com.virtualcave.rate.domain.dto.updater.RateUpdateDto;

import java.util.List;
import java.util.Optional;

public interface RateService {

    List<RateDto> list();

    Optional<RateDto> find(RateByIdFinderDto finderDto);

    RateDto findOrNotFound(RateByIdFinderDto finderDto);

    RateDto create(RateCreateDto createDto);

    RateDto update(RateUpdateDto createDto);

    void delete(Integer id);

}
