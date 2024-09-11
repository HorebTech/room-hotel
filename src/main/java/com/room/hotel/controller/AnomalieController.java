package com.room.hotel.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.room.hotel.dto.AnomalieDto;
import com.room.hotel.service.AnomalieService;
import static com.room.hotel.utils.ApiUrls.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AnomalieController {

    private final AnomalieService service;

    @PostMapping(POST_ROOT_URL)
    public ResponseEntity<AnomalieDto> create(@RequestBody AnomalieDto anomalieDto) {
        AnomalieDto anomalie = service.create(anomalieDto);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }

    @PutMapping(UPDATE_ROOT_URL)
    public ResponseEntity<AnomalieDto> update(@RequestBody AnomalieDto anomalieDto) {
        AnomalieDto anomalie = service.update(anomalieDto);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }

    @GetMapping(GET_ALL_ROOT_URL)
    public ResponseEntity<List<AnomalieDto>> allAnomalies() {
        List<AnomalieDto> anomalies = service.allAnomalies();
        return new ResponseEntity<>(anomalies, HttpStatus.OK);
    }

    @GetMapping(GET_ROOT_URL)
    public ResponseEntity<AnomalieDto> getAnomalieById(@RequestParam UUID id) {
        AnomalieDto anomalie = service.getAnomalieById(id);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }
}
