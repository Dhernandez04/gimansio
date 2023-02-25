package com.dhernandez.gimnasio.persistence.crud;

import com.dhernandez.gimnasio.persistence.entity.Usuario;
import com.dhernandez.gimnasio.persistence.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UsuarioCrudRepository extends JpaRepository<Usuario,Long>{

    Optional<Usuario> findByUsuario(String usuario);
    Optional<List<Usuario>> getByEstado(Estado estado);

    Boolean existsByEmail(String email);

    Boolean existsByUsuario(String usuario);
}
