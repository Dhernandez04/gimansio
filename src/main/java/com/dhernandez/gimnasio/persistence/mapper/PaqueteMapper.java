package com.dhernandez.gimnasio.persistence.mapper;

import com.dhernandez.gimnasio.domain.dto.PaqueteDto;
import com.dhernandez.gimnasio.persistence.entity.Paquete;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaqueteMapper {

    PaqueteDto toPaqueteDto(Paquete paquete);

    List<PaqueteDto> toPaqueteDtos(List<Paquete> paquetes);

    Paquete toPaquete(PaqueteDto rolDto);
}
