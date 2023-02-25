package com.dhernandez.gimnasio.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaqueteDto {
    private Long id;
    private String nombre;
    private Long  imagenId;
    private ImagenDto imagen;
    private String descripcion;
    private BigDecimal precio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Long idUsuario;
}
