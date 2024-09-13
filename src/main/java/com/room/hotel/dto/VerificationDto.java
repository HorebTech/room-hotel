package com.room.hotel.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.room.hotel.model.Verification;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VerificationDto {
    private UUID id;
    private Verification.Etat etatVerification;
    private String observation;
    @NotNull(message = "Chambre concernée requise!")
    private UUID idChambre;
    private LocalDateTime createdDate;
}
