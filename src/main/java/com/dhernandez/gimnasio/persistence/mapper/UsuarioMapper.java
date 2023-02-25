package com.dhernandez.gimnasio.persistence.mapper;

import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioInDto;
import com.dhernandez.gimnasio.persistence.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring",uses = {RolMapper.class})
public interface UsuarioMapper {

    UsuarioDto toUsuarioDto(Usuario usuario);

    List<UsuarioDto> toUsuarioDtos(List<Usuario> usuarios);

    Usuario toUsuario(UsuarioDto usuarioDto);
    Usuario toUsuario(UsuarioInDto usuarioDto);
}
