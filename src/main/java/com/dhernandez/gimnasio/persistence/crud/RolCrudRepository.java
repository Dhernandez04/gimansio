package com.dhernandez.gimnasio.persistence.crud;

import com.dhernandez.gimnasio.persistence.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolCrudRepository extends JpaRepository<Rol,Long> {
}
