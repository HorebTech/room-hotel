package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.AnomalieDto;
import com.room.hotel.model.Anomalie;

@Mapper(componentModel = "spring")
public interface AnomalieMapper {
    AnomalieDto toDto(Anomalie anomalie);

    Anomalie toEntity(AnomalieDto anomalieDto);

    List<AnomalieDto> toDtos(List<Anomalie> anomalieList);

    List<Anomalie> toEntities(List<AnomalieDto> anomalieDtos);

    void updateEntityFromDto(AnomalieDto enqueteDto, @MappingTarget Anomalie anomalie);

    default Anomalie map(UUID id) {
        if (id == null) {
            return null;
        }
        Anomalie anomalie = new Anomalie();
        return anomalie;
    }
}
