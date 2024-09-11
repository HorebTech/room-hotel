package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.EquipementDto;
import com.room.hotel.model.Equipement;

@Mapper(componentModel = "spring")
public interface EquipementMapper {
    EquipementDto toDto(Equipement equipement);

    Equipement toEntity(EquipementDto equipementDto);

    List<EquipementDto> toDtos(List<Equipement> equipementList);

    List<Equipement> toEntities(List<EquipementDto> equipementDtos);

    void updateEntityFromDto(EquipementDto enqueteDto, @MappingTarget Equipement enquete);

    default Equipement map(UUID id) {
        if (id == null) {
            return null;
        }
        Equipement equipement = new Equipement();
        equipement.setId(id);
        return equipement;
    }
}
