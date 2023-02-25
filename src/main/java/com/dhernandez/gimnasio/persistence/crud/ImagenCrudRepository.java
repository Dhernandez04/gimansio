package com.dhernandez.gimnasio.persistence.crud;

import com.dhernandez.gimnasio.persistence.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenCrudRepository extends JpaRepository<Imagen,Long> {
}
