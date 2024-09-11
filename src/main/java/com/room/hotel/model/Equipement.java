package com.room.hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.room.hotel.enums.EtatEquipementStatus;

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
@Table(name = "equipements")
public class Equipement extends AuditEntity {

    private String nom;
    private String description;
    @Enumerated(EnumType.STRING)
    private EtatEquipementStatus etatEquipement;

    private UUID idChambre;
}