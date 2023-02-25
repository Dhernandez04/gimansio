package com.dhernandez.gimnasio.domain.service;

import com.dhernandez.gimnasio.domain.dto.ImagenDto;
import com.dhernandez.gimnasio.persistence.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImagenService {
    @Autowired
    ImagenRepository imagenRepository;


    public  ImagenDto guardar(ImagenDto imagenDto){
        return imagenRepository.guardar(imagenDto);
    }

    public  void eliminar(Long id){
         imagenRepository.eliminar(id);
    }
}
