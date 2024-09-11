package com.room.hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import com.room.hotel.enums.EtatChambreStatus;
import com.room.hotel.enums.TypeChambreStatus;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
@SuperBuilder
@Table(name = "chambre")
public class Chambre extends AuditEntity {
    private String numero;
    private String localisation;
    @Enumerated(EnumType.STRING)
    private TypeChambreStatus type;
    @Enumerated(EnumType.STRING)
    private EtatChambreStatus etatChambre;
    private String prix;

}
