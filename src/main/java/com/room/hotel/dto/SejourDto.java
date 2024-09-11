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
public class SejourDto extends AuditEntityDto {

    private String description;
    private Long nbrPersonnes;
    private Long dureeSejour;

    private UUID idUtilisateur;
    private UUID idClient;
}
