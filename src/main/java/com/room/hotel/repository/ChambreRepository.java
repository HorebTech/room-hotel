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

import com.room.hotel.dto.ChambreDto;
import com.room.hotel.model.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, UUID>, JpaSpecificationExecutor<Chambre> {
    @Query("SELECT c FROM Chambre c")
    Page<Chambre> findAllChambres(Pageable pageable);

    @Query("""
            SELECT chambre
            FROM Chambre chambre
            WHERE chambre.numero = :numero
            """)
    Optional<ChambreDto> findByNumero(@Param("numero") String numero);

    @Query("SELECT c FROM Chambre c WHERE c.etatChambre = :etatChambre")
    Page<Chambre> findAllChambreByEtat(@Param("etatChambre") Chambre.Etat etatChambre, Pageable pageable);

    @Query("SELECT c FROM Chambre c WHERE c.etatChambre = :etatChambre")
    List<Chambre> findChambreByEtat(@Param("etatChambre") Chambre.Etat etatChambre);
}
