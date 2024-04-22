package com.siwft.cargo.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehiculo_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id")
    private Usuario conductor;

    @Size(max = 50)
    @NotNull
    @Column(name = "placa", nullable = false, length = 50)
    private String placa;

    @Size(max = 50)
    @Column(name = "modelo", length = 50)
    private String modelo;

    @Size(max = 50)
    @Column(name = "marca", length = 50)
    private String marca;

}