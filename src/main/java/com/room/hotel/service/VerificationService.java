package com.room.hotel.service;

import java.util.List;
import java.util.UUID;

import com.room.hotel.dto.VerificationDto;

public interface VerificationService {
    VerificationDto create(VerificationDto verificationDto);

    VerificationDto update(VerificationDto verificationDto);

    VerificationDto getVerificationById(UUID id);

    List<VerificationDto> allVerifications();
}
