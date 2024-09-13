package com.room.hotel.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.room.hotel.dto.EquipementDto;
import com.room.hotel.model.Equipement;

@Mapper(componentModel = "spring")
public interface EquipementMapper {
    EquipementDto toDto(Equipement equipement);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Equipement toEntity(EquipementDto equipementDto);

    List<EquipementDto> toDtos(List<Equipement> equipementList);

    List<Equipement> toEntities(List<EquipementDto> equipementDtos);

}
