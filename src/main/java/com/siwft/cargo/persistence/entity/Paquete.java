package com.siwft.cargo.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paquetes")
public class Paquete {
    @Id
    @Column(name = "paquete_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    @Size(max = 50)
    @Column(name = "estado", length = 50)
    private String estado;

}