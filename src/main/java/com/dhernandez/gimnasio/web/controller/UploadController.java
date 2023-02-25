package com.dhernandez.gimnasio.web.controller;

import com.dhernandez.gimnasio.domain.dto.ImagenDto;
import com.dhernandez.gimnasio.domain.dto.PaqueteDto;
import com.dhernandez.gimnasio.domain.service.CloudinaryService;
import com.dhernandez.gimnasio.domain.service.ImagenService;
import com.dhernandez.gimnasio.domain.service.PaqueteService;
import com.dhernandez.gimnasio.persistence.entity.Paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/uploads")
public class UploadController {

    @Autowired
    CloudinaryService uploadFileService;

    @Autowired
    PaqueteService paqueteService;

    @Autowired
    ImagenService imagenService;

    @PutMapping("/paquete/{id}")
    public ResponseEntity<?> subirImagen(
            @PathVariable Long id,
            @PathVariable("imagen") MultipartFile imagen) throws IOException {

        BufferedImage bi = ImageIO.read(imagen.getInputStream());
        if(bi == null){
            return  new ResponseEntity<>(Collections.singletonMap("error","Imagen no valida"),HttpStatus.BAD_REQUEST);
        }
        Optional<PaqueteDto> paqueteDto = paqueteService.obtenerPorId(id);
        PaqueteDto paqueteDB;
        Map result;
        if (paqueteDto.isPresent()) {

            PaqueteDto paquete = paqueteDto.get();
            if(paquete.getImagen() !=null ){
                paquete.setImagenId(null);
                paqueteDB = paqueteService.guardar(paquete);
                imagenService.eliminar(paquete.getImagen().getId());
                uploadFileService.eliminar(paquete.getImagen().getImagenId());

            }
            result = uploadFileService.uploadImagen(imagen);
            ImagenDto imagenDto = new ImagenDto();
            imagenDto.setNombre((String)result.get("original_filename"));
            imagenDto.setImagenId((String)result.get("public_id"));
            imagenDto.setPathUrl((String)result.get("url"));

            ImagenDto imagenDB = imagenService.guardar(imagenDto);
            paquete.setImagenId(imagenDB.getId());
            paquete.setImagen(imagenDB);
            paqueteDB = paqueteService.guardar(paquete);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(paqueteDB, HttpStatus.OK);

    }

    @DeleteMapping("/eliminar/{id}/{idimage}")
    public ResponseEntity<?> eliminar(
            @PathVariable Long id,
            @PathVariable String idimage) throws IOException {
        Optional<PaqueteDto> paqueteDto = paqueteService.obtenerPorId(id);
        PaqueteDto paqueteDB;

        if (paqueteDto.isPresent()) {
            PaqueteDto paquete = paqueteDto.get();
            paquete.setImagenId(null);
            paquete.setImagen(null);

            uploadFileService.eliminar(idimage);
            paqueteDB = paqueteService.guardar(paquete);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(paqueteDB, HttpStatus.OK);

    }
}
