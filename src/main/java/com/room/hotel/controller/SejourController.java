package com.room.hotel.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.room.hotel.dto.SejourDto;
import com.room.hotel.service.SejourService;
import static com.room.hotel.utils.ApiUrls.DELETE;
import static com.room.hotel.utils.ApiUrls.GET_ALL;
import static com.room.hotel.utils.ApiUrls.GET_ONE;
import static com.room.hotel.utils.ApiUrls.POST;
import static com.room.hotel.utils.ApiUrls.ROOT_URL;
import com.room.hotel.utils.PageResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT_URL + "/sejour")
public class SejourController {

    private final SejourService service;

    @PostMapping(POST)
    public ResponseEntity<SejourDto> create(@RequestBody @Valid SejourDto sejourDto)
            throws IOException {
        return ResponseEntity.ok(service.createSejour(sejourDto));
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping(DELETE + "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteSejour(id);
        return ResponseEntity.noContent().build();
    }

    // @PutMapping(UPDATE + "/{id}")
    // public ResponseEntity<SejourDto> update(@PathVariable UUID id, @RequestBody
    // SejourDto sejourDto)
    // throws IOException {
    // return ResponseEntity.ok(service.updateSejour(id, SejourDto));
    // }

    @GetMapping(GET_ALL)
    public ResponseEntity<PageResponse<SejourDto>> getAllSejours(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.getAllSejours(page, size));
    }

    @GetMapping(GET_ONE + "/{id}")
    public ResponseEntity<SejourDto> getSejour(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getSejour(id));
    }

    // @GetMapping(GET_ALL + "/{date}")
    // public ResponseEntity<PageResponse<SejourDto>> getAllSejoursByDate(
    // @PathVariable LocalDateTime date,
    // @RequestParam(name = "page", defaultValue = "0", required = false) int page,
    // @RequestParam(name = "size", defaultValue = "10", required = false) int size)
    // {
    // return ResponseEntity.ok(service.getAllSejoursByDate(date, page, size));
    // }
}
