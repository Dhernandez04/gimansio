package com.dhernandez.gimnasio.domain.service;

import com.dhernandez.gimnasio.domain.dto.PaqueteDto;

import com.dhernandez.gimnasio.domain.repository.IPaqueteRepository;
import com.dhernandez.gimnasio.domain.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteService {
    IPaqueteRepository paqueteRepository;

    @Autowired
    public PaqueteService(IPaqueteRepository paqueteRepository) {

        this.paqueteRepository = paqueteRepository;
    }

    public List<PaqueteDto> obtenerTodos(Long idUsuario){

        return paqueteRepository.obtenerTodos(idUsuario);
    }

    public Optional<PaqueteDto> obtenerPorId(Long id){
        return paqueteRepository.obtenerPorId(id);
    }

    public PaqueteDto guardar(PaqueteDto paqueteDto){
        return paqueteRepository.guardar(paqueteDto);
    }

    public boolean eliminar(Long id ){
        return obtenerPorId(id).map(usuario -> {
            paqueteRepository.eliminar(id);
            return true;
        }).orElse(false);
    }
}
