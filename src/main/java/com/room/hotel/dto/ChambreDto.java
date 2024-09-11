package com.room.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChambreDto extends AuditEntityDto {

    private String numero;
    private String localisation;
    private String type;
    private String etatChambre;
    private String prix;
}
