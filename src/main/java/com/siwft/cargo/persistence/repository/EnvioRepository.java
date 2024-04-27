package com.siwft.cargo.persistence.repository;

import com.siwft.cargo.persistence.entity.Envio;
import com.siwft.cargo.service.dto.EnvioInfo;
import com.siwft.cargo.service.dto.EnvioYVehiculoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {

    @Query(value = "SELECT new com.siwft.cargo.service.dto.EnvioYVehiculoInfo(" +
            "en.id, " +
            "ve.id, " +
            "en.fechaHoraInicio, " +
            "en.fechaHoraEstimadaLlegada, " +
            "en.fechaHoraRealLlegada, " +
            "en.fechaHoraCarga, " +
            "en.direccionDestino, " +
            "en.direccionInicio, " +
            "en.latDestino, " +
            "en.lngDestino, " +
            "en.latInicio, " +
            "en.lngInicio, " +
            "en.estado, " +
            "ve.placa, " +
            "ve.lat, " +
            "ve.lng) " +
            " FROM Envio en INNER JOIN EnvioPaquete enp ON en = enp.envio " +
            " INNER JOIN Paquete pa ON pa = enp.paquete " +
            " INNER JOIN Vehiculo ve ON ve = en.vehiculo " +
            " WHERE pa.usuario.identificacion = :identificacion")
    List<EnvioYVehiculoInfo> listarEnviosPorUsuario(String identificacion);


    @Query(value = "SELECT new com.siwft.cargo.service.dto.EnvioYVehiculoInfo(" +
            "en.id, " +
            "ve.id, " +
            "en.fechaHoraInicio, " +
            "en.fechaHoraEstimadaLlegada, " +
            "en.fechaHoraRealLlegada, " +
            "en.fechaHoraCarga, " +
            "en.direccionDestino, " +
            "en.direccionInicio, " +
            "en.latDestino, " +
            "en.lngDestino, " +
            "en.latInicio, " +
            "en.lngInicio, " +
            "en.estado, " +
            "ve.placa, " +
            "ve.lat, " +
            "ve.lng) " +
            " FROM Envio en " +
            " INNER JOIN Vehiculo ve ON ve = en.vehiculo " +
            " WHERE ve.conductor.identificacion = :identificacion")
    List<EnvioYVehiculoInfo> findByConductor(String identificacion);
    @Query(value = "SELECT new com.siwft.cargo.service.dto.EnvioYVehiculoInfo(" +
            "en.id, " +
            "ve.id, " +
            "en.fechaHoraInicio, " +
            "en.fechaHoraEstimadaLlegada, " +
            "en.fechaHoraRealLlegada, " +
            "en.fechaHoraCarga, " +
            "en.direccionDestino, " +
            "en.direccionInicio, " +
            "en.latDestino, " +
            "en.lngDestino, " +
            "en.latInicio, " +
            "en.lngInicio, " +
            "en.estado, " +
            "ve.placa, " +
            "ve.lat, " +
            "ve.lng) " +
            " FROM Envio en " +
            " INNER JOIN Vehiculo ve ON ve = en.vehiculo " +
            " WHERE en.id = :idEnvio")
    EnvioYVehiculoInfo buscarEnvioById(Long idEnvio);
}