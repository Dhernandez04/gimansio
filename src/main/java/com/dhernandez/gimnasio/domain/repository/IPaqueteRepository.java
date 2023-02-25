package com.dhernandez.gimnasio.domain.repository;

import com.dhernandez.gimnasio.domain.dto.PaqueteDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioInDto;

import java.util.List;
import java.util.Optional;

public interface IPaqueteRepository {

   List<PaqueteDto> obtenerTodos(Long idUsuario);


    Optional<PaqueteDto> obtenerPorId(Long id);

    PaqueteDto  guardar(PaqueteDto usuarioInDto);

    void eliminar (Long id);
}
