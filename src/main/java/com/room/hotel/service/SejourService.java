package com.room.hotel.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.room.hotel.dto.SejourDto;
import com.room.hotel.exception.ResourceNotFoundException;
import com.room.hotel.model.Sejour;
import com.room.hotel.model.mappers.SejourMapper;
import com.room.hotel.repository.SejourRepository;
import com.room.hotel.utils.PageResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SejourService {

    private final SejourRepository repository;
    private final SejourMapper mapper;

    @Transactional
    public SejourDto createSejour(SejourDto sejourDto) throws IOException {
        Sejour sejour = mapper.toEntity(sejourDto);
        Sejour savedSejour = repository.save(sejour);
        return mapper.toDto(savedSejour);
    }

    @Transactional
    public void deleteSejour(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aucun Sejour trouvé");
        }
        repository.deleteById(id);
    }

    public SejourDto getSejour(UUID id) {
        Sejour sejour = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sejour non trouvé!"));
        return mapper.toDto(sejour);
    }

    public PageResponse<SejourDto> getAllSejours(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Sejour> sejours = repository.findAllSejours(pageable);
        List<SejourDto> sejourList = mapper.toDtos(repository.findAll());
        return new PageResponse<>(
                sejourList,
                sejours.getNumber(),
                sejours.getSize(),
                sejours.getTotalElements(),
                sejours.getTotalPages(),
                sejours.isFirst(),
                sejours.isLast());
    }
}
