package com.room.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.room.hotel.model.Sejour;

public interface SejourRepository extends JpaRepository<Sejour, UUID> {

}
