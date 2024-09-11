package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.SejourDto;

public interface SejourService {
    SejourDto create(SejourDto sejourDto);

    SejourDto update(SejourDto sejourDto);

    SejourDto getSejourById(UUID id);

    List<SejourDto> allSejours();
}
