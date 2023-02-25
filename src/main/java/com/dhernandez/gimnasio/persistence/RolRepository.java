package com.dhernandez.gimnasio.persistence;

import com.dhernandez.gimnasio.domain.dto.RolDto;
import com.dhernandez.gimnasio.domain.repository.IRolRepository;
import com.dhernandez.gimnasio.persistence.crud.RolCrudRepository;
import com.dhernandez.gimnasio.persistence.entity.Rol;
import com.dhernandez.gimnasio.persistence.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolRepository implements IRolRepository {

    private RolMapper mapper;

    private RolCrudRepository crudRepository;

    @Autowired
    public RolRepository(RolMapper mapper, RolCrudRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }

    @Override
    public List<RolDto> obtenerTodos() {

        return mapper.toRolDtos(crudRepository.findAll());
    }

    @Override
    public Optional<RolDto> obtenerPorId(Long id) {

        return crudRepository.findById(id).map(rol -> mapper.toRolDto(rol));
    }

    @Override
    public RolDto guardar(RolDto rolDto) {
        Rol rol = mapper.toRol(rolDto);
        return mapper.toRolDto(crudRepository.save(rol));
    }


}
