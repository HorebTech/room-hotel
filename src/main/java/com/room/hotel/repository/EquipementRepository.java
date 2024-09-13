package com.room.hotel.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.room.hotel.dto.EquipementDto;
import com.room.hotel.model.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, UUID>, JpaSpecificationExecutor<Equipement> {

    /*** Requête pour récupérer tous les équipements créés */
    @Query("SELECT c FROM Equipement c")
    Page<Equipement> findAllEquipements(Pageable pageable);

    @Query("""
            SELECT equipement
            FROM Equipement equipement
            WHERE equipement.nom = :nom
            """)
    Optional<EquipementDto> findByNom(@Param("nom") String nom);

    /***
     * Requête pour récupérer tous les équipements présent dans une chambre en
     * fonction de l'ID de la chambre
     */
    @Query("SELECT e FROM Equipement e WHERE e.idChambre = :idChambre")
    Page<Equipement> findAllEquipementsByIdChambre(@Param("idChambre") UUID idChambre, Pageable pageable);

    @Query("SELECT e FROM Equipement e WHERE e.idChambre = :idChambre")
    List<Equipement> findAllEquipementsByChambre(@Param("idChambre") UUID idChambre);

    /*** Requête pour récupérer tous les équipements en fonction de l'état */
    @Query("SELECT e FROM Equipement e WHERE e.etatEquipement = :etatEquipement")
    Page<Equipement> findAllEquipementsByEtat(@Param("etatEquipement") Equipement.Etat etatEquipement,
            Pageable pageable);

    @Query("SELECT e FROM Equipement e WHERE e.etatEquipement = :etatEquipement")
    List<Equipement> findEquipementByEtat(@Param("etatEquipement") Equipement.Etat etatEquipement);

    /***
     * Requête pour récupérer tous les équipements en fonction de l'état et en
     * fonction d'une chambre
     */
    @Query("SELECT e FROM Equipement e WHERE e.etatEquipement = :etatEquipement AND e.idChambre = :idChambre")
    Page<Equipement> findAllEquipementsByEtatAndChambre(@Param("etatEquipement") Equipement.Etat etatEquipement,
            @Param("idChambre") UUID idChambre,
            Pageable pageable);

    @Query("SELECT e FROM Equipement e WHERE e.etatEquipement = :etatEquipement AND e.idChambre = :idChambre")
    List<Equipement> findEquipementByEtatAndChambre(@Param("etatEquipement") Equipement.Etat etatEquipement,
            @Param("idChambre") UUID idChambre);

}
