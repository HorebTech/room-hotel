package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.PaiementDto;
import com.room.hotel.model.Paiement;

@Mapper(componentModel = "spring")
public interface PaiementMapper {
    PaiementDto toDto(Paiement paiement);

    Paiement toEntity(PaiementDto paiementDto);

    List<PaiementDto> toDtos(List<Paiement> paiementList);

    List<Paiement> toEntities(List<PaiementDto> paiementDtos);

    void updateEntityFromDto(PaiementDto enqueteDto, @MappingTarget Paiement enquete);

    default Paiement map(UUID id) {
        if (id == null) {
            return null;
        }
        Paiement paiement = new Paiement();
        paiement.setId(id);
        return paiement;
    }
}
