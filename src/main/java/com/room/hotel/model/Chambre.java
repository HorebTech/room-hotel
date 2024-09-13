package com.room.hotel.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "chambre")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(unique = true)
    private String numero;
    private String localisation;

    @Enumerated(EnumType.STRING)
    private Type typeChambre;
    @Enumerated(EnumType.STRING)
    private Etat etatChambre;
    private String prix;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy ' à ' HH:mm:ss")
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy ' à ' HH:mm:ss")
    private LocalDateTime lastModifiedDate;

    public enum Type {
        SUITE,
        DOUBLE,
        SIMPLE,
        LUXE,
        TRIPLE
    }

    public enum Etat {
        LIBRE,
        NETTOYAGE,
        OCCUPEE
    }

}
