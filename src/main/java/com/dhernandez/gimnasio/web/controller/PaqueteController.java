package com.dhernandez.gimnasio.web.controller;

import com.dhernandez.gimnasio.domain.dto.PaqueteDto;
import com.dhernandez.gimnasio.domain.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/paquetes")
@RestController
public class PaqueteController {

    @Autowired
    PaqueteService paqueteService;

    @GetMapping("/obtener-todos")
    public ResponseEntity<List<PaqueteDto>> obtenerTodos(@RequestParam("usuarioId") Long usuarioId){
       return  new ResponseEntity<>(paqueteService.obtenerTodos(usuarioId), HttpStatus.OK);
    }
    @GetMapping("/obtener-por-id/{id}")
    public ResponseEntity<Optional<PaqueteDto>> obtenerPorId(@PathVariable Long id){
        return  new ResponseEntity<>(paqueteService.obtenerPorId(id), HttpStatus.OK);
    }
    @PostMapping("/guardar")
    public ResponseEntity<PaqueteDto> guardar(@RequestBody PaqueteDto paqueteDto){
        return new ResponseEntity<>(paqueteService.guardar(paqueteDto),HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PaqueteDto> actualizar(@RequestBody PaqueteDto paqueteDto){
         Optional<PaqueteDto> paqueteDB =  paqueteService.obtenerPorId(paqueteDto.getId());
          PaqueteDto paquete = paqueteDB.get();
          if (!paqueteDB.isPresent()){
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          paquete.setNombre(paqueteDto.getNombre());
          paquete.setDescripcion(paqueteDto.getDescripcion());
          paquete.setPrecio(paqueteDto.getPrecio());
          paquete.setFechaInicio(paqueteDto.getFechaInicio());
          paquete.setFechaFin(paqueteDto.getFechaFin());
        return new ResponseEntity<>(paqueteService.guardar(paquete),HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<Boolean> eliminar(@PathVariable Long id){
        Optional<PaqueteDto> paqueteDB =  paqueteService.obtenerPorId(id);
        if (!paqueteDB.isPresent()){
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
        paqueteService.eliminar(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }


}
