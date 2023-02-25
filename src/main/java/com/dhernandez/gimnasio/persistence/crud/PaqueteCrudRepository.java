package com.dhernandez.gimnasio.persistence.crud;

import com.dhernandez.gimnasio.persistence.entity.Paquete;
import com.dhernandez.gimnasio.persistence.entity.Usuario;
import com.dhernandez.gimnasio.persistence.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaqueteCrudRepository extends JpaRepository<Paquete,Long> {

    List<Paquete> getByIdUsuario(Long idUsuario);
}
