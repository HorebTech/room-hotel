package com.room.hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "checklist")
public class Checklist extends AuditEntity {

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
