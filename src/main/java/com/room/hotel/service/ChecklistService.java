package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.ChecklistDto;

public interface ChecklistService {
    ChecklistDto create(ChecklistDto checklistDto);

    ChecklistDto update(ChecklistDto checklistDto);

    ChecklistDto getChecklistById(UUID id);

    List<ChecklistDto> allChecklists();
}
