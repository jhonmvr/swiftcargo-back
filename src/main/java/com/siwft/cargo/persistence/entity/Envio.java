package com.siwft.cargo.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "envios")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "envio_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @NotNull
    @Column(name = "fecha_hora_inicio", nullable = false)
    private Instant fechaHoraInicio;

    @Column(name = "fecha_hora_estimada_llegada")
    private Instant fechaHoraEstimadaLlegada;

    @Column(name = "fecha_hora_real_llegada")
    private Instant fechaHoraRealLlegada;

    @Column(name = "fecha_hora_carga")
    private Instant fechaHoraCarga;

    @Size(max = 255)
    @Column(name = "direccion_destino")
    private String direccionDestino;

    @Size(max = 255)
    @Column(name = "direccion_inicio")
    private String direccionInicio;

    @NotNull
    @Column(name = "lat_destino", nullable = false)
    private Integer latDestino;

    @NotNull
    @Column(name = "lng_destino", nullable = false)
    private Integer lngDestino;

    @NotNull
    @Column(name = "lat_inicio", nullable = false)
    private Integer latInicio;

    @NotNull
    @Column(name = "lng_inicio", nullable = false)
    private Integer lngInicio;

    @Size(max = 50)
    @Column(name = "estado", length = 50)
    private String estado;

}