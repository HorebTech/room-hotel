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
public class VerificationDto extends AuditEntityDto {

    private String etatVerification;
    private String observation;

    private UUID idChambre;
    private UUID idUtilisateur;
    private UUID idChecklist;
}
