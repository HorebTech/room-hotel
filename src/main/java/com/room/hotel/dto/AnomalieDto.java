package com.room.hotel.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnomalieDto extends AuditEntityDto {

    private String description;
    private String photos;
    private UUID idChecklist;
}
