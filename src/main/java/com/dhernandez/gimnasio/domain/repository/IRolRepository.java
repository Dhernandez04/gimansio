package com.dhernandez.gimnasio.domain.repository;

import com.dhernandez.gimnasio.domain.dto.RolDto;


import java.util.List;
import java.util.Optional;

public interface IRolRepository {
    List<RolDto> obtenerTodos();

    Optional<RolDto> obtenerPorId(Long id);

    RolDto  guardar(RolDto rolDto);


}
