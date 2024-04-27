package com.siwft.cargo.service.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Builder
public class UsuarioDto {

    private Integer id;

    private String nombre;

    private String email;

    private String telefono;

    private String contrasena;

    private String tipoUsuario;

    private String licencia;

    private String direccion;

    private String tokenNotificacion;
    private String identificacion;

}
