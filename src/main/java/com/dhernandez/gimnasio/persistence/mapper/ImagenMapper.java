package com.dhernandez.gimnasio.persistence.mapper;

import com.dhernandez.gimnasio.domain.dto.ImagenDto;
import com.dhernandez.gimnasio.persistence.entity.Imagen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagenMapper {

    ImagenDto toImagenDto(Imagen imagen);

    Imagen toImagen(ImagenDto imagenDto);
}
