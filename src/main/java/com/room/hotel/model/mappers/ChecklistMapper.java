package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.ChecklistDto;
import com.room.hotel.model.Checklist;

@Mapper(componentModel = "spring")
public interface ChecklistMapper {
    ChecklistDto toDto(Checklist checklist);

    Checklist toEntity(ChecklistDto checklistDto);

    List<ChecklistDto> toDtos(List<Checklist> checklistList);

    List<Checklist> toEntities(List<ChecklistDto> checklistDtos);

    void updateEntityFromDto(ChecklistDto enqueteDto, @MappingTarget Checklist enquete);

    default Checklist map(UUID id) {
        if (id == null) {
            return null;
        }
        Checklist checklist = new Checklist();
        checklist.setId(id);
        return checklist;
    }
}
