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
public class ChecklistDto extends AuditEntityDto {

    private String sol;
    private String sanitaires;
    private String miroirs;
    private String murs;
    private String eclairage;
    private String fenetres;
    private String balcon;
    private String porte;
    private String objetOublie;

    private UUID idEquipement;
    private UUID idVerification;
}
