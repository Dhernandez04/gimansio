package com.dhernandez.gimnasio.domain.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String usuario;
    private String password;
}
