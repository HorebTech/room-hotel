package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.ClientDto;

public interface ClientService {
    ClientDto create(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);

    ClientDto getClientById(UUID id);

    List<ClientDto> allClients();
}
