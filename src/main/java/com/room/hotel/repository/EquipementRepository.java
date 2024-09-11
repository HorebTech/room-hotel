package com.room.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.room.hotel.model.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, UUID> {

}
