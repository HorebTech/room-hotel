package com.room.hotel.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.room.hotel.dto.VerificationDto;
import com.room.hotel.model.Verification;

@Mapper(componentModel = "spring")
public interface VerificationMapper {
    VerificationDto toDto(Verification verification);

    @Mapping(target = "lastModifiedDate", ignore = true)
    Verification toEntity(VerificationDto verificationDto);

    List<VerificationDto> toDtos(List<Verification> verificationList);

    List<Verification> toEntities(List<VerificationDto> verificationDtos);

}
