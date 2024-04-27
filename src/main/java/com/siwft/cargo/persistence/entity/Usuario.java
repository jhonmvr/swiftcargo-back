package com.siwft.cargo.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 50)
    @Column(name = "telefono", length = 50)
    private String telefono;

    @Size(max = 255)
    @NotNull
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Size(max = 50)
    @NotNull
    @Column(name = "tipo_usuario", nullable = false, length = 50)
    private String tipoUsuario;

    @Size(max = 50)
    @Column(name = "licencia", length = 50)
    private String licencia;

    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "token_notificacion")
    private String tokenNotificacion;
    @Size(max = 10)
    @Column(name = "identificacion")
    private String identificacion;

}