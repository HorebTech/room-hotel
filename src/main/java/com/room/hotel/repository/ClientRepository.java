package com.room.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.room.hotel.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
