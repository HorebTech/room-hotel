package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.ChambreDto;
import com.room.hotel.model.Chambre;

@Mapper(componentModel = "spring")
public interface ChambreMapper {
    ChambreDto toDto(Chambre chambre);

    Chambre toEntity(ChambreDto chambreDto);

    List<ChambreDto> toDtos(List<Chambre> chambreList);

    List<Chambre> toEntities(List<ChambreDto> chambreDtos);

    void updateEntityFromDto(ChambreDto enqueteDto, @MappingTarget Chambre enquete);

    default Chambre map(UUID id) {
        if (id == null) {
            return null;
        }
        Chambre chambre = new Chambre();
        chambre.setId(id);
        return chambre;
    }
}
