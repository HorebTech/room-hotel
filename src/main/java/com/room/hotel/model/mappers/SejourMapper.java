package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.SejourDto;
import com.room.hotel.model.Sejour;

@Mapper(componentModel = "spring")
public interface SejourMapper {
    SejourDto toDto(Sejour sejour);

    Sejour toEntity(SejourDto sejourDto);

    List<SejourDto> toDtos(List<Sejour> sejourList);

    List<Sejour> toEntities(List<SejourDto> sejourDtos);

    void updateEntityFromDto(SejourDto enqueteDto, @MappingTarget Sejour enquete);

    default Sejour map(UUID id) {
        if (id == null) {
            return null;
        }
        Sejour sejour = new Sejour();
        sejour.setId(id);
        return sejour;
    }
}
