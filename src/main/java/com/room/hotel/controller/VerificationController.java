package com.room.hotel.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.room.hotel.dto.VerificationDto;
import com.room.hotel.service.VerificationService;
import static com.room.hotel.utils.ApiUrls.DELETE;
import static com.room.hotel.utils.ApiUrls.GET_ALL;
import static com.room.hotel.utils.ApiUrls.GET_ONE;
import static com.room.hotel.utils.ApiUrls.POST;
import static com.room.hotel.utils.ApiUrls.ROOT_URL;
import static com.room.hotel.utils.ApiUrls.UPDATE;
import com.room.hotel.utils.PageResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT_URL + "/verification")
public class VerificationController {

    private final VerificationService service;

    @PostMapping(POST)
    public ResponseEntity<VerificationDto> create(@RequestBody @Valid VerificationDto verificationDto)
            throws IOException {
        return ResponseEntity.ok(service.createVerification(verificationDto));
    }

    @DeleteMapping(DELETE + "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteVerification(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(UPDATE + "/{id}")
    public ResponseEntity<VerificationDto> update(@PathVariable UUID id, @RequestBody VerificationDto verificationDto)
            throws IOException {
        return ResponseEntity.ok(service.updateVerification(id, verificationDto));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<PageResponse<VerificationDto>> getAllVerifications(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.getAllVerifications(page, size));
    }

    @GetMapping(GET_ONE + "/{id}")
    public ResponseEntity<VerificationDto> getVerification(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getVerification(id));
    }

    @GetMapping(GET_ALL + "/{date}")
    public ResponseEntity<PageResponse<VerificationDto>> getAllVerificationsByDate(
            @PathVariable LocalDateTime date,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.getAllVerificationsByDate(date, page, size));
    }
}
