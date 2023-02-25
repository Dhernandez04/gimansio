package com.dhernandez.gimnasio.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
