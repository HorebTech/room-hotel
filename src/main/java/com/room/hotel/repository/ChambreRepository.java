package com.room.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.room.hotel.model.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, UUID> {

}
