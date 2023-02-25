package com.dhernandez.gimnasio.domain.dto;

import lombok.Data;

@Data
public class ImagenDto {
    private Long id;

    private String nombre;

    private String pathUrl;

    private String imagenId;
}
