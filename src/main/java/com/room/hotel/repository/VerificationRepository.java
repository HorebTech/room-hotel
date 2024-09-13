package com.room.hotel.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.room.hotel.model.Verification;

public interface VerificationRepository
        extends JpaRepository<Verification, UUID>, JpaSpecificationExecutor<Verification> {

    /*** Requête pour récupérer la liste de toutes les vérifications */
    @Query("SELECT v FROM Verification v")
    Page<Verification> findAllVerifications(Pageable pageable);

    /***
     * Requête pour récupérer toutes les vérifications à partir d'une date donnée
     */
    @Query("SELECT v FROM Verification v WHERE v.createdDate = :createdDate")
    Page<Verification> findAllVerificationByDate(@Param("createdDate") LocalDateTime createdDate, Pageable pageable);

    @Query("SELECT v FROM Verification v WHERE v.createdDate = :createdDate")
    List<Verification> findVerificationDate(@Param("createdDate") LocalDateTime createdDate);

}
