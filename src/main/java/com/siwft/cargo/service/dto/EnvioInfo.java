package com.siwft.cargo.service.dto;

import com.siwft.cargo.persistence.enums.EstadoEnvio;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Projection for {@link com.siwft.cargo.persistence.entity.Envio}
 */
public interface EnvioInfo {
    Integer getId();

    Instant getFechaHoraInicio();

    Instant getFechaHoraEstimadaLlegada();

    Instant getFechaHoraRealLlegada();

    Instant getFechaHoraCarga();

    String getDireccionDestino();

    String getDireccionInicio();

    BigDecimal getLatDestino();

    BigDecimal getLngDestino();

    BigDecimal getLatInicio();

    BigDecimal getLngInicio();

    EstadoEnvio getEstado();
}