package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.PaiementDto;

public interface PaiementService {
    PaiementDto create(PaiementDto paiementDto);

    PaiementDto update(PaiementDto paiementDto);

    PaiementDto getPaiementById(UUID id);

    List<PaiementDto> allPaiements();
}
