package com.room.hotel.model.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.room.hotel.dto.ClientDto;
import com.room.hotel.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);

    Client toEntity(ClientDto clientDto);

    List<ClientDto> toDtos(List<Client> clientList);

    List<Client> toEntities(List<ClientDto> clientDtos);

    void updateEntityFromDto(ClientDto enqueteDto, @MappingTarget Client enquete);

    default Client map(UUID id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
