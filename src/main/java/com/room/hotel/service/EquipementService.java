package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.EquipementDto;

public interface EquipementService {
    EquipementDto create(EquipementDto equipementDto);

    EquipementDto update(EquipementDto equipementDto);

    EquipementDto getEquipementById(UUID id);

    List<EquipementDto> allEquipements();
}
