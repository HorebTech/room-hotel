package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.VerificationDto;
import com.room.hotel.model.Verification;

@Mapper(componentModel = "spring")
public interface VerificationMapper {
    VerificationDto toDto(Verification verification);

    Verification toEntity(VerificationDto verificationDto);

    List<VerificationDto> toDtos(List<Verification> verificationList);

    List<Verification> toEntities(List<VerificationDto> verificationDtos);

    void updateEntityFromDto(VerificationDto enqueteDto, @MappingTarget Verification enquete);

    default Verification map(UUID id) {
        if (id == null) {
            return null;
        }
        Verification verification = new Verification();
        verification.setId(id);
        return verification;
    }
}
