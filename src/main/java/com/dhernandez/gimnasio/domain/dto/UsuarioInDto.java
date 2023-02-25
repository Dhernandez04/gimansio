package com.dhernandez.gimnasio.domain.dto;

import com.dhernandez.gimnasio.persistence.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInDto {
    private Long id;
    private String usuario;
    private String nombres;
    private String password;
    private String apellidos;
    private String email;
    private String telefono;
    private Long idRol;
}
