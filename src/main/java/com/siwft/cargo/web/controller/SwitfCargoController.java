package com.siwft.cargo.web.controller;

import com.siwft.cargo.persistence.entity.Envio;
import com.siwft.cargo.persistence.entity.Mensaje;
import com.siwft.cargo.persistence.entity.Vehiculo;
import com.siwft.cargo.service.SwiftCargoService;
import com.siwft.cargo.service.dto.EnvioYVehiculoInfo;
import com.siwft.cargo.service.dto.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/SwiftCargo")
@Tag(name = "SwiftCargo", description = "APi for SwiftCargo.")
public class SwitfCargoController {
    @Autowired
    private SwiftCargoService swiftCargoService;

    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/check")
    ResponseEntity<?> check() {

        return ResponseEntity.ok(true);
    }

    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/paque")
    ResponseEntity<?> paque(@Param("id") Integer id) {
        swiftCargoService.buscarPaque(id);

        return ResponseEntity.ok(true);
    }
    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/paquete")
    ResponseEntity<?> paquete(@Param("id") Integer id) {

        swiftCargoService.buscarPaquete(id);
        return ResponseEntity.ok(true);
    }

    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/listarEnviosPorUsuario")
    ResponseEntity<?> listarEnviosPorUsuario(@Param("identificacion") String identificacion) {


        return ResponseEntity.ok(swiftCargoService.listarEnviosPorUsuario(identificacion));
    }

    @Operation(summary = "Obtain weather query history.")
    @PostMapping("/actualizarubicacionVehiculo")
    ResponseEntity<?> actualizarubicacionVehiculo(@RequestBody Vehiculo vehiculo) {


        return ResponseEntity.ok(swiftCargoService.actualizarubicacionVehiculo(vehiculo));
    }
    @Operation(summary = "Obtain weather query history.")
    @PostMapping("/cambiarEstadoEnvio")
    ResponseEntity<?> cambiarEstadoEnvio(@RequestBody Envio envio) {


        return ResponseEntity.ok(swiftCargoService.cambiarEstadoEnvio(envio));
    }

    @Operation(summary = "Obtain weather query history.")
    @PostMapping("/enviarMensaje")
    ResponseEntity<?> enviarMensaje(@RequestBody Mensaje mensaje) {


        return ResponseEntity.ok(swiftCargoService.enviarMensaje(mensaje));
    }

    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/buscarEnvioByConductor")
    ResponseEntity<?> buscarEnvioByConductor(@Param("identificacion") String identificacion) {


        return ResponseEntity.ok(swiftCargoService.buscarEnvioByConductor(identificacion));
    }
    @Operation(summary = "Obtain weather query history.")
    @PostMapping("/actualizarUbicacionVehiculo")
    ResponseEntity<?> actualizarUbicacionVehiculo(@RequestBody EnvioYVehiculoInfo Enviculo) {
        ;
        return ResponseEntity.ok(swiftCargoService.actualizarUbicacionVehiculo(Enviculo));
    }
    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/buscarEnvioById")
    ResponseEntity<?> buscarEnvioById(@Param("idEnvio") Long idEnvio) {
        ;
        return ResponseEntity.ok(swiftCargoService.buscarEnvioById(idEnvio));
    }

}
