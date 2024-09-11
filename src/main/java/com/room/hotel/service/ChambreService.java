package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.ChambreDto;

public interface ChambreService {
    ChambreDto create(ChambreDto chambreDto);

    ChambreDto update(ChambreDto chambreDto);

    ChambreDto getChambreById(UUID id);

    List<ChambreDto> allChambres();
}
