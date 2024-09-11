package com.room.hotel.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EquipementDto extends AuditEntityDto {

    private String nom;
    private String description;
    private String etatEquipement;

    private UUID idChambre;
}
