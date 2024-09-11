package com.room.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.room.hotel.model.Verification;

public interface VerificationRepository extends JpaRepository<Verification, UUID> {

}
