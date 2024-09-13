package com.room.hotel.dto;

import java.util.UUID;

import com.room.hotel.model.Chambre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChambreDto {
    private UUID id;
    @NotBlank(message = "Numéro de chambre manquant!")
    private String numero;
    @NotBlank(message = "Localisation de la chambre manquante!")
    private String localisation;
    @NotNull(message = "Type de chambre requis!")
    private Chambre.Type typeChambre;
    @NotNull(message = "État de la chambre requis!")
    private Chambre.Etat etatChambre;
    @NotBlank(message = "Prix de la chambre requis!")
    private String prix;
}
