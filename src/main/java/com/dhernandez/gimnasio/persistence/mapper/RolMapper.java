package com.dhernandez.gimnasio.persistence.mapper;

import com.dhernandez.gimnasio.domain.dto.RolDto;
import com.dhernandez.gimnasio.persistence.entity.Rol;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDto toRolDto(Rol rol);

    List<RolDto> toRolDtos(List<Rol> roles);

    Rol toRol(RolDto rolDto);
}
