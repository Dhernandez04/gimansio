package com.dhernandez.gimnasio.domain.repository;

import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioInDto;


import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {

    List<UsuarioDto> obtenerTodos();

    Optional<UsuarioDto> findByUsuario(String usuario);


    Optional<UsuarioDto> obtenerPorId(Long id);

    UsuarioDto  guardar(UsuarioInDto usuarioInDto);

    UsuarioDto eliminar (Long id);
}
