package com.siwft.cargo.service.dto;

import com.siwft.cargo.persistence.entity.Envio;
import com.siwft.cargo.persistence.entity.Vehiculo;
import com.siwft.cargo.persistence.enums.EstadoEnvio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@Data
public class EnvioYVehiculoInfo {

    private Integer id;

    private Integer idVehiculo;
    private Instant fechaHoraInicio;
    private Instant fechaHoraEstimadaLlegada;
    private Instant fechaHoraRealLlegada;
    private Instant fechaHoraCarga;
    private String direccionDestino;
    private String direccionInicio;
    private BigDecimal latDestino;
    private BigDecimal lngDestino;
    private BigDecimal latInicio;
    private BigDecimal lngInicio;
    private EstadoEnvio estado;
    private String placa;
    private BigDecimal lat;
    private BigDecimal lng;
}
