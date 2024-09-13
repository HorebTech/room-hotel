package com.room.hotel.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.room.hotel.dto.SejourDto;
import com.room.hotel.model.Sejour;

@Mapper(componentModel = "spring")
public interface SejourMapper {
    SejourDto toDto(Sejour sejour);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Sejour toEntity(SejourDto sejourDto);

    List<SejourDto> toDtos(List<Sejour> sejourList);

    List<Sejour> toEntities(List<SejourDto> sejourDtos);
}
