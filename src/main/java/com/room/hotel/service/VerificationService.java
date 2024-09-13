package com.room.hotel.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.room.hotel.dto.VerificationDto;
import com.room.hotel.exception.ResourceNotFoundException;
import com.room.hotel.model.Verification;
import com.room.hotel.model.mappers.VerificationMapper;
import com.room.hotel.repository.VerificationRepository;
import com.room.hotel.utils.PageResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationService {

    private final VerificationRepository repository;
    private final VerificationMapper mapper;

    @Transactional
    public VerificationDto createVerification(VerificationDto verificationDto) throws IOException {
        Verification verification = mapper.toEntity(verificationDto);
        Verification savedVerification = repository.save(verification);
        return mapper.toDto(savedVerification);
    }

    @Transactional
    public void deleteVerification(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aucune Verification trouvée");
        }
        repository.deleteById(id);
    }

    @Transactional
    public VerificationDto updateVerification(UUID id, VerificationDto verificationDto) throws IOException {
        Verification existingVerification = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune vérification trouvée!"));
        existingVerification.setEtatVerification(verificationDto.getEtatVerification());
        Verification updatedVerification = repository.save(existingVerification);
        return mapper.toDto(updatedVerification);
    }

    public VerificationDto getVerification(UUID id) {
        Verification verification = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Verification non trouvée!"));
        return mapper.toDto(verification);
    }

    public PageResponse<VerificationDto> getAllVerifications(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Verification> verifications = repository.findAllVerifications(pageable);
        List<VerificationDto> verificationList = mapper.toDtos(repository.findAll());
        return new PageResponse<>(
                verificationList,
                verifications.getNumber(),
                verifications.getSize(),
                verifications.getTotalElements(),
                verifications.getTotalPages(),
                verifications.isFirst(),
                verifications.isLast());
    }

    public PageResponse<VerificationDto> getAllVerificationsByDate(LocalDateTime date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Verification> verifications = repository.findAllVerificationByDate(date, pageable);
        List<VerificationDto> verificationList = mapper.toDtos(repository.findVerificationDate(date));
        return new PageResponse<>(
                verificationList,
                verifications.getNumber(),
                verifications.getSize(),
                verifications.getTotalElements(),
                verifications.getTotalPages(),
                verifications.isFirst(),
                verifications.isLast());
    }
}
