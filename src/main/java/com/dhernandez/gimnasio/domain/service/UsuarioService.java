package com.dhernandez.gimnasio.domain.service;

import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioInDto;
import com.dhernandez.gimnasio.domain.repository.IUsuarioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    Log Logger = LogFactory.getLog(UsuarioService.class);
    IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> obtenerTodos(){
        return usuarioRepository.obtenerTodos();
    }

    public Optional<UsuarioDto> obtenerUsuarioId(Long id){
        Logger.info("Inicia metodo obtenerUsuarioId(id) "+id);
        Optional<UsuarioDto> usuario = usuarioRepository.obtenerPorId(id);

        Logger.info("obteniendo resultado de la consulta "+usuario);
        Logger.info("Finaliza metodo obtenerUsuarioId(id) "+id);
        return usuario;
    }
    public Optional<UsuarioDto> getByUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario);
    }

    public UsuarioDto guardar(UsuarioInDto usuarioInDto){
        return usuarioRepository.guardar(usuarioInDto);
    }

    public boolean eliminar(Long id ){
        return obtenerUsuarioId(id).map(usuario -> {
            usuarioRepository.eliminar(id);
            return true;
        }).orElse(false);
    }

}
