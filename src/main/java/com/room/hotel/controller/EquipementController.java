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

import com.room.hotel.dto.EquipementDto;
import com.room.hotel.model.Equipement;
import com.room.hotel.service.EquipementService;
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
@RequestMapping(ROOT_URL + "/equipement")
public class EquipementController {

    private final EquipementService service;

    @PostMapping(POST)
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<EquipementDto> create(@RequestBody @Valid EquipementDto equipementDto) throws IOException {
        return ResponseEntity.ok(service.createEquipement(equipementDto));
    }

    @PutMapping(UPDATE + "/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<EquipementDto> update(@PathVariable UUID id, @RequestBody EquipementDto equipementDto)
            throws IOException {
        return ResponseEntity.ok(service.updateEquipement(id, equipementDto));
    }

    @PutMapping(UPDATE + "/etat/{id}")
    public ResponseEntity<EquipementDto> updateEtat(@PathVariable UUID id, @RequestBody EquipementDto equipementDto)
            throws IOException {
        return ResponseEntity.ok(service.updateEquipementEtat(id, equipementDto));
    }

    @DeleteMapping(DELETE + "/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }

    /*** Récupérer tous les équipements existants */
    @GetMapping(GET_ALL)
    public ResponseEntity<PageResponse<EquipementDto>> getAllEquipements(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.getAllEquipements(page, size));
    }

    /*** Récupérer tous les équipements dans une chambre */
    @GetMapping(GET_ALL + "/{id}")
    public ResponseEntity<PageResponse<EquipementDto>> getAllEquipementsByIdChambre(
            @PathVariable UUID id,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.getAllEquipementsByIdChambre(id, page, size));
    }

    /*** Récupérer tous les équipements par état */
    @GetMapping(GET_ALL + "/etat/{etatEquipement}")
    public ResponseEntity<PageResponse<EquipementDto>> getAllEquipementsByEtatEquipement(
            @PathVariable Equipement.Etat etatEquipement,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.getAllEquipementsByEtatEquipement(etatEquipement, page, size));
    }

    /*** Récupérer tous les équipements par état en fonction d'une chambre */
    @GetMapping(GET_ALL + "/{etatEquipement}/{id}")
    public ResponseEntity<PageResponse<EquipementDto>> findAllEquipementsByEtatAndChambre(
            @PathVariable Equipement.Etat etatEquipement,
            @PathVariable UUID id,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(service.findAllEquipementsByEtatAndChambre(etatEquipement, id, page, size));
    }

    @GetMapping(GET_ONE + "/{id}")
    public ResponseEntity<EquipementDto> getEquipement(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getEquipement(id));
    }
}
