package com.dhernandez.gimnasio.persistence.entity;

import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paquetes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_imagen")
    private Long imagenId;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id_imagen",updatable = false,insertable = false)
    private Imagen imagen;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "id_usuario")
    private Long idUsuario;


}
