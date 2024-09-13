package com.room.hotel.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.room.hotel.dto.ChambreDto;
import com.room.hotel.model.Chambre;
import com.room.hotel.service.ChambreService;
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
@RequestMapping(ROOT_URL + "/chambre")
public class ChambreController {

    private final ChambreService service;

    @PostMapping(POST)
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<ChambreDto> create(@RequestBody @Valid ChambreDto chambreDto) throws IOException {
        return ResponseEntity.ok(service.createChambre(chambreDto));
    }

    @PutMapping(UPDATE + "/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<ChambreDto> update(@PathVariable UUID id, @RequestBody ChambreDto chambreDto)
            throws IOException {
        return ResponseEntity.ok(service.updateChambre(id, chambreDto));
    }

    @PutMapping(UPDATE + "/etat/{id}")
    public ResponseEntity<ChambreDto> updateChambreEtat(@PathVariable UUID id, @RequestBody ChambreDto chambreDto)
            throws IOException {
        return ResponseEntity.ok(service.updateChambreEtat(id, chambreDto));
    }

    @DeleteMapping(DELETE + "/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteChambre(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<PageResponse<ChambreDto>> getAllChambres(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.getAllChambres(page, size));
    }

    @GetMapping(GET_ONE + "/{id}")
    public ResponseEntity<ChambreDto> getChambre(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getChambre(id));
    }

    @GetMapping(GET_ALL + "/{etat}")
    public ResponseEntity<PageResponse<ChambreDto>> findAllChambreByEtat(
            @PathVariable Chambre.Etat etat,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.findAllChambreByEtat(etat, page, size));
    }
}
