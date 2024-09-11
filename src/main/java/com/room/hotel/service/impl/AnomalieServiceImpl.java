package com.room.hotel.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.AnomalieDto;
import com.room.hotel.model.Anomalie;
import com.room.hotel.model.mappers.AnomalieMapper;
import com.room.hotel.repository.AnomalieRepository;
import com.room.hotel.service.AnomalieService;

@RequiredArgsConstructor
@Service
public class AnomalieServiceImpl implements AnomalieService {

    private final AnomalieRepository repository;
    private final AnomalieMapper mapper;

    @Override
    public AnomalieDto create(AnomalieDto anomalieDto) {
        Anomalie anomalie = mapper.toEntity(anomalieDto);
        return mapper.toDto(repository.save(anomalie));
    }

    @Override
    public AnomalieDto update(AnomalieDto anomalieDto) {
        return null;
    }

    @Override
    public AnomalieDto getAnomalieById(UUID id) {
        return null;
    }

    @Override
    public List<AnomalieDto> allAnomalies() {
        return mapper.toDtos(repository.findAll());
    }
}
