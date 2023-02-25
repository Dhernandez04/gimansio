package com.dhernandez.gimnasio.persistence;

import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioInDto;
import com.dhernandez.gimnasio.domain.repository.IUsuarioRepository;
import com.dhernandez.gimnasio.persistence.crud.UsuarioCrudRepository;
import com.dhernandez.gimnasio.persistence.entity.Usuario;
import com.dhernandez.gimnasio.persistence.enums.Estado;
import com.dhernandez.gimnasio.persistence.mapper.UsuarioMapper;
import com.dhernandez.gimnasio.web.exceptions.UniqueException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements IUsuarioRepository {
    private UsuarioCrudRepository usuarioCrudRepository;
    private UsuarioMapper mapper;
    @Autowired
    public UsuarioRepository(UsuarioCrudRepository usuarioCrudRepository, UsuarioMapper mapper) {
        this.usuarioCrudRepository = usuarioCrudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public List<UsuarioDto> obtenerTodos() {
        return mapper.toUsuarioDtos(usuarioCrudRepository.getByEstado(Estado.ACTIVO).orElse(Collections.emptyList()));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDto> findByUsuario(String usuario) {
        return usuarioCrudRepository.findByUsuario(usuario).map(usuarioDB -> mapper.toUsuarioDto(usuarioDB));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDto> obtenerPorId(Long id) {

        return usuarioCrudRepository.findById(id).map(usuario -> mapper.toUsuarioDto(usuario));
    }

    @Override
    @Transactional
    public UsuarioDto guardar(UsuarioInDto usuarioInDto) {

        if(usuarioCrudRepository.existsByEmail(usuarioInDto.getEmail()) ){
            throw  new UniqueException("El email ya se encuentra registrado.");
        }
        if( usuarioCrudRepository.existsByUsuario(usuarioInDto.getUsuario())){
            throw  new UniqueException("El usuario ya se encuentra registrado.");
        }

        Usuario usuario = mapper.toUsuario(usuarioInDto);
        return mapper.toUsuarioDto(usuarioCrudRepository.save(usuario));
    }

    @Override
    @Transactional
    public UsuarioDto eliminar(Long id) {
        Optional<UsuarioDto> usuarioDto = obtenerPorId(id);
        if(usuarioDto.isPresent()){
            Usuario usuarioDB = mapper.toUsuario(usuarioDto.get());
            usuarioDB.setEstado(Estado.INACTIVO);
            return mapper.toUsuarioDto(usuarioCrudRepository.save(usuarioDB));
        }
        return usuarioDto.orElse(null);
    }
}
