package com.dhernandez.gimnasio.web.controller;

import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import com.dhernandez.gimnasio.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/obtener-por-id/{id}")
    public ResponseEntity<Optional<UsuarioDto>> obtenerPorId(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.obtenerUsuarioId(id), HttpStatus.OK);
    }

}
