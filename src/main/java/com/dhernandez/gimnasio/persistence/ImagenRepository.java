package com.dhernandez.gimnasio.persistence;

import com.dhernandez.gimnasio.domain.dto.ImagenDto;
import com.dhernandez.gimnasio.domain.repository.IImagenRepository;
import com.dhernandez.gimnasio.persistence.crud.ImagenCrudRepository;
import com.dhernandez.gimnasio.persistence.entity.Imagen;
import com.dhernandez.gimnasio.persistence.mapper.ImagenMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ImagenRepository implements IImagenRepository {
    @Autowired
    ImagenCrudRepository imagenCrudRepository;

    @Autowired
    ImagenMapper mapper;
    @Transactional
    @Override
    public ImagenDto guardar(ImagenDto imagenDto) {
        Imagen imagen = mapper.toImagen(imagenDto);
        return mapper.toImagenDto(imagenCrudRepository.save(imagen));
    }

    @Override
    public void eliminar(Long id) {
        imagenCrudRepository.deleteById(id);
    }
}
