package com.room.hotel.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.room.hotel.dto.ChambreDto;
import com.room.hotel.exception.ResourceNotFoundException;
import com.room.hotel.model.Chambre;
import com.room.hotel.model.mappers.ChambreMapper;
import com.room.hotel.repository.ChambreRepository;
import com.room.hotel.utils.PageResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChambreService {

    private final ChambreRepository repository;
    private final ChambreMapper mapper;

    @Transactional
    public ChambreDto createChambre(ChambreDto chambreDto) throws IOException {
        if (repository.findByNumero(chambreDto.getNumero()).isPresent()) {
            throw new IllegalStateException("Ce numéro de chambre existe déjà dans votre établissement!");
        }
        Chambre chambre = mapper.toEntity(chambreDto);
        Chambre savedChambre = repository.save(chambre);
        return mapper.toDto(savedChambre);
    }

    @Transactional
    public ChambreDto updateChambre(UUID id, ChambreDto chambreDto) throws IOException {
        Chambre existingChambre = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune chambre trouvée!"));
        existingChambre.setNumero(chambreDto.getNumero());
        existingChambre.setLocalisation(chambreDto.getLocalisation());
        existingChambre.setPrix(chambreDto.getPrix());
        existingChambre.setEtatChambre(chambreDto.getEtatChambre());
        existingChambre.setTypeChambre(chambreDto.getTypeChambre());

        Chambre updatedChambre = repository.save(existingChambre);
        return mapper.toDto(updatedChambre);
    }

    @Transactional
    public ChambreDto updateChambreEtat(UUID id, ChambreDto chambreDto) throws IOException {
        Chambre existingChambre = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune chambre trouvée!"));
        existingChambre.setEtatChambre(chambreDto.getEtatChambre());
        Chambre updatedChambre = repository.save(existingChambre);
        return mapper.toDto(updatedChambre);
    }

    @Transactional
    public void deleteChambre(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aucune chambre trouvée");
        }
        repository.deleteById(id);
    }

    public ChambreDto getChambre(UUID id) {
        Chambre chambre = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chambre non trouvée!"));
        return mapper.toDto(chambre);
    }

    public PageResponse<ChambreDto> getAllChambres(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Chambre> chambres = repository.findAllChambres(pageable);
        List<ChambreDto> rooms = mapper.toDtos(repository.findAll());
        return new PageResponse<>(
                rooms,
                chambres.getNumber(),
                chambres.getSize(),
                chambres.getTotalElements(),
                chambres.getTotalPages(),
                chambres.isFirst(),
                chambres.isLast());
    }

    public PageResponse<ChambreDto> findAllChambreByEtat(Chambre.Etat etatChambre, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Chambre> chambres = repository.findAllChambreByEtat(etatChambre, pageable);
        List<ChambreDto> rooms = mapper.toDtos(repository.findChambreByEtat(etatChambre));
        return new PageResponse<>(
                rooms,
                chambres.getNumber(),
                chambres.getSize(),
                chambres.getTotalElements(),
                chambres.getTotalPages(),
                chambres.isFirst(),
                chambres.isLast());
    }
}
