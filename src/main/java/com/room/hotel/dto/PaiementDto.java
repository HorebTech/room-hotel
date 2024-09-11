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
public class PaiementDto extends AuditEntityDto {

    private String montant;
    private UUID idSejour;
    private UUID idClient;
}
