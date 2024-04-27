package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.Envio;
import com.siwft.cargo.persistence.entity.EnvioPaquete;
import com.siwft.cargo.persistence.entity.Mensaje;
import com.siwft.cargo.persistence.entity.Vehiculo;
import com.siwft.cargo.persistence.repository.EnvioPaqueteRepository;
import com.siwft.cargo.persistence.repository.EnvioRepository;
import com.siwft.cargo.persistence.repository.MensajeRepository;
import com.siwft.cargo.persistence.repository.VehiculoRepository;
import com.siwft.cargo.service.dto.EnvioYVehiculoInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SwiftCargoService {

    private final EnvioPaqueteRepository envioPaqueteRepository;

    private final EnvioPaqueteService envioPaqueteService;

    private final EnvioRepository envioRepository;

    private final VehiculoRepository vehiculoRepository;

    private final GoogleClientService googleClientService;
    private final MensajeRepository mensajeRepository;

    public void buscarPaque(Integer idPaque) {
        envioPaqueteRepository.save(envioPaqueteRepository.findById(idPaque).orElse(new EnvioPaquete()));
    }

    public void buscarPaquete(Integer idPaquete) {
        EnvioPaquete p = envioPaqueteService.findById(idPaquete).orElse(null);
        if (p == null) {
            return;
        }
        envioPaqueteService.save(p);

    }

    public List<EnvioYVehiculoInfo> listarEnviosPorUsuario(String identificacion) {
        return envioRepository.listarEnviosPorUsuario(identificacion);
    }

    public Vehiculo actualizarubicacionVehiculo(Vehiculo vehiculo) {
        Vehiculo ve = vehiculoRepository.findById(vehiculo.getId()).orElse(null);
        if (ve == null) {
            return null;
        }
        ve.setLat(vehiculo.getLat());
        ve.setLng(vehiculo.getLng());
        return vehiculoRepository.save(ve);
    }

    @Transactional
    public Envio cambiarEstadoEnvio(Envio envio) {
        Envio env = envioRepository.findById(envio.getId()).orElse(null);
        if (env == null) throw new RuntimeException();
        env.setEstado(envio.getEstado());
        envioRepository.save(env);
        EnvioPaquete envioPaquete = envioPaqueteRepository.findEnvioPaqueteByEnvio_Id(env.getId());
        if (envioPaquete == null) throw new RuntimeException();
        String token = envioPaquete.getPaquete().getUsuario().getTokenNotificacion();
        String titulo = "Tu paquete";
        String mensaje = "Se actualizo el estado de tu envio ahora esta " + envio.getEstado().getEstado();
        googleClientService.sendToToken(token, titulo, mensaje);
        return envio;
    }

    public Object enviarMensaje(Mensaje mensaje) {
        Envio env = envioRepository.findById(mensaje.getEnvio().getId()).orElse(null);
        if (env == null) throw new RuntimeException();

        EnvioPaquete envioPaquete = envioPaqueteRepository.findEnvioPaqueteByEnvio_Id(env.getId());
        if (envioPaquete == null) throw new RuntimeException();
        String token = envioPaquete.getPaquete().getUsuario().getTokenNotificacion();
        String titulo = "Mensaje";
        String ms = mensaje.getContenido();
        mensajeRepository.save(mensaje);
        googleClientService.sendToToken(token, titulo, ms);
        return envioPaquete;
    }

    public EnvioYVehiculoInfo buscarEnvioByConductor(String identificacion) {
        List<EnvioYVehiculoInfo> list = envioRepository.findByConductor(identificacion);
        return list != null && !list.isEmpty()?list.get(0):null;


    }

    public Object actualizarUbicacionVehiculo(EnvioYVehiculoInfo enviculo) {
        Vehiculo vehiculo = vehiculoRepository.findById(enviculo.getIdVehiculo()).orElse(null);
        if(vehiculo == null){
            throw new RuntimeException("ERROR NO SE PUDO ENCONTRAR EL VEHICULO");
        }
        vehiculo.setLng(enviculo.getLng());
        vehiculo.setLat(enviculo.getLat());
        vehiculoRepository.save(vehiculo);

        return enviculo;
    }

    public EnvioYVehiculoInfo buscarEnvioById(Long idEnvio) {
        return envioRepository.buscarEnvioById(idEnvio);
    }
}
