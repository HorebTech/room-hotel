package com.room.hotel.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.room.hotel.dto.EquipementDto;
import com.room.hotel.exception.ResourceNotFoundException;
import com.room.hotel.model.Equipement;
import com.room.hotel.model.mappers.EquipementMapper;
import com.room.hotel.repository.EquipementRepository;
import com.room.hotel.utils.PageResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipementService {

    private final EquipementRepository repository;
    private final EquipementMapper mapper;

    @Transactional
    public EquipementDto createEquipement(EquipementDto equipementDto) throws IOException {
        if (repository.findByNom(equipementDto.getNom()).isPresent()) {
            throw new IllegalStateException("Cet équipement est déjà enrégistré!");
        }
        Equipement equipement = mapper.toEntity(equipementDto);
        Equipement savedEquipement = repository.save(equipement);
        return mapper.toDto(savedEquipement);
    }

    @Transactional
    public EquipementDto updateEquipement(UUID id, EquipementDto equipementDto) throws IOException {
        Equipement existingEquipement = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun Equipement trouvé!"));
        existingEquipement.setNom(equipementDto.getNom());
        existingEquipement.setDescription(equipementDto.getDescription());
        existingEquipement.setEtatEquipement(equipementDto.getEtatEquipement());
        existingEquipement.setIdChambre(equipementDto.getIdChambre());

        Equipement updatedEquipement = repository.save(existingEquipement);
        return mapper.toDto(updatedEquipement);
    }

    @Transactional
    public EquipementDto updateEquipementEtat(UUID id, EquipementDto equipementDto) throws IOException {
        Equipement existingEquipement = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun Equipement trouvé!"));
        existingEquipement.setEtatEquipement(equipementDto.getEtatEquipement());
        Equipement updatedEquipement = repository.save(existingEquipement);
        return mapper.toDto(updatedEquipement);
    }

    @Transactional
    public void deleteEquipement(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aucun Equipement trouvé");
        }
        repository.deleteById(id);
    }

    public EquipementDto getEquipement(UUID id) {
        Equipement equipement = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement non trouvé!"));
        return mapper.toDto(equipement);
    }

    public PageResponse<EquipementDto> getAllEquipements(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Equipement> equipements = repository.findAllEquipements(pageable);
        List<EquipementDto> listEquipements = mapper.toDtos(repository.findAll());
        return new PageResponse<>(
                listEquipements,
                equipements.getNumber(),
                equipements.getSize(),
                equipements.getTotalElements(),
                equipements.getTotalPages(),
                equipements.isFirst(),
                equipements.isLast());
    }

    public PageResponse<EquipementDto> getAllEquipementsByIdChambre(UUID id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Equipement> equipements = repository.findAllEquipementsByIdChambre(id, pageable);
        List<EquipementDto> listEquipements = mapper.toDtos(repository.findAllEquipementsByChambre(id));
        return new PageResponse<>(
                listEquipements,
                equipements.getNumber(),
                equipements.getSize(),
                equipements.getTotalElements(),
                equipements.getTotalPages(),
                equipements.isFirst(),
                equipements.isLast());
    }

    public PageResponse<EquipementDto> getAllEquipementsByEtatEquipement(Equipement.Etat etatEquipement, int page,
            int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Equipement> equipements = repository.findAllEquipementsByEtat(etatEquipement, pageable);
        List<EquipementDto> listEquipements = mapper.toDtos(repository.findEquipementByEtat(etatEquipement));
        return new PageResponse<>(
                listEquipements,
                equipements.getNumber(),
                equipements.getSize(),
                equipements.getTotalElements(),
                equipements.getTotalPages(),
                equipements.isFirst(),
                equipements.isLast());
    }

    public PageResponse<EquipementDto> findAllEquipementsByEtatAndChambre(Equipement.Etat etatEquipement, UUID id,
            int page,
            int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Equipement> equipements = repository.findAllEquipementsByEtatAndChambre(etatEquipement, id, pageable);
        List<EquipementDto> listEquipements = mapper
                .toDtos(repository.findEquipementByEtatAndChambre(etatEquipement, id));
        return new PageResponse<>(
                listEquipements,
                equipements.getNumber(),
                equipements.getSize(),
                equipements.getTotalElements(),
                equipements.getTotalPages(),
                equipements.isFirst(),
                equipements.isLast());
    }
}
