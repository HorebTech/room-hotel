package com.room.hotel.dto;

import java.util.UUID;

import com.room.hotel.model.Equipement;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EquipementDto {

    private UUID id;
    @NotNull(message = "Nom de l'équipement requis!")
    private String nom;
    private String description;
    private Equipement.Etat etatEquipement;

    private UUID idChambre;
}
