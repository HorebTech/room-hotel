package com.room.hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.room.hotel.enums.EtatVerificationStatus;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
@SuperBuilder
@Table(name = "verification")
public class Verification extends AuditEntity {

    @Enumerated(EnumType.STRING)
    private EtatVerificationStatus etatVerification;
    private String observation;

    private UUID idChambre;
    private UUID idUtilisateur;
    private UUID idChecklist;
}
