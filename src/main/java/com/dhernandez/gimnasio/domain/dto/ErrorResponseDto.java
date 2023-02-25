package com.dhernandez.gimnasio.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private final boolean  error = true;
    private String mensaje;
    private int codigoEstado;
    private String path;

    private List<ValidationErrorDto> errores;
}
