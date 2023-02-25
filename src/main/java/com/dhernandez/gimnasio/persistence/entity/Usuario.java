package com.dhernandez.gimnasio.persistence.entity;

import com.dhernandez.gimnasio.persistence.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario",unique = true)
    private String usuario;

    @Column(name = "password")
    private String password;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "id_rol")
    private Long idRol;
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_rol",updatable = false,insertable = false)
    private Rol rol;


    @PrePersist
    public void  prePersist(){
        this.fechaRegistro = LocalDate.now();
        this.estado = Estado.ACTIVO;
    }

}
