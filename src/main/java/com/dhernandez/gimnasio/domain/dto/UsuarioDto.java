package com.dhernandez.gimnasio.domain.dto;

import com.dhernandez.gimnasio.persistence.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private Long idRol;
    private String usuario;
    private String password;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;
    private Estado estado;
    private RolDto rol;
}
