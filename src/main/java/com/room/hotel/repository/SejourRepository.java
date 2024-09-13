package com.room.hotel.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.room.hotel.model.Sejour;

public interface SejourRepository extends JpaRepository<Sejour, UUID>, JpaSpecificationExecutor<Sejour> {
    @Query("SELECT s FROM Sejour s")
    Page<Sejour> findAllSejours(Pageable pageable);
}
