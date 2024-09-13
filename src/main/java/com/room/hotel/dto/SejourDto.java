package com.room.hotel.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class SejourDto {

    private UUID id;

    private String codeSejour;

    private String nomPrenom;
    private String emailClient;
    private String contactClient;

    private String description;
    private Long nbrPersonnes;
    private Long dureeSejour;
    private String montantTotal;

    private String dateArrivee;
    private String dateDepart;

    private UUID idUtilisateur;
    private UUID idChambre;
}
