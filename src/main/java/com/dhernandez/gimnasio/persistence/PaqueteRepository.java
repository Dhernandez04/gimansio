package com.dhernandez.gimnasio.persistence;

import com.dhernandez.gimnasio.domain.dto.PaqueteDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioInDto;
import com.dhernandez.gimnasio.domain.repository.IPaqueteRepository;
import com.dhernandez.gimnasio.persistence.crud.PaqueteCrudRepository;
import com.dhernandez.gimnasio.persistence.entity.Paquete;
import com.dhernandez.gimnasio.persistence.mapper.PaqueteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PaqueteRepository implements IPaqueteRepository {
    private PaqueteCrudRepository paqueteCrudRepository;

    private PaqueteMapper paqueteMapper;

    @Autowired

    public PaqueteRepository(PaqueteCrudRepository paqueteCrudRepository, PaqueteMapper paqueteMapper) {
        this.paqueteCrudRepository = paqueteCrudRepository;
        this.paqueteMapper = paqueteMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaqueteDto> obtenerTodos(Long idUsuario) {
        return paqueteMapper.toPaqueteDtos(paqueteCrudRepository.getByIdUsuario(idUsuario));
    }



    @Override
    @Transactional(readOnly = true)
    public Optional<PaqueteDto> obtenerPorId(Long id) {
        return paqueteCrudRepository.findById(id).map(paquete->paqueteMapper.toPaqueteDto(paquete));
    }

    @Override
    @Transactional
    public PaqueteDto guardar(PaqueteDto paqueteDto) {
        Paquete paquete = paqueteMapper.toPaquete(paqueteDto);
        return paqueteMapper.toPaqueteDto(paqueteCrudRepository.save(paquete));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        paqueteCrudRepository.deleteById(id);
    }
}
