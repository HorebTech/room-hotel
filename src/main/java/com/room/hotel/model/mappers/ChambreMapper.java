package com.room.hotel.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.room.hotel.dto.ChambreDto;
import com.room.hotel.model.Chambre;

@Mapper(componentModel = "spring")
public interface ChambreMapper {

    ChambreDto toDto(Chambre chambre);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Chambre toEntity(ChambreDto chambreDto);

    List<ChambreDto> toDtos(List<Chambre> chambreList);

    List<Chambre> toEntities(List<ChambreDto> chambreDtos);

}
