package com.dhernandez.gimnasio.domain.repository;

import com.dhernandez.gimnasio.domain.dto.ImagenDto;
import com.dhernandez.gimnasio.domain.dto.RolDto;

public interface IImagenRepository {

    ImagenDto guardar(ImagenDto ImagenDto);

    void eliminar(Long id);
}
