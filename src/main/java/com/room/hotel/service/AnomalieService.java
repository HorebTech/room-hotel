package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.AnomalieDto;

public interface AnomalieService {
    AnomalieDto create(AnomalieDto anomalieDto);

    AnomalieDto update(AnomalieDto anomalieDto);

    AnomalieDto getAnomalieById(UUID id);

    List<AnomalieDto> allAnomalies();
}
