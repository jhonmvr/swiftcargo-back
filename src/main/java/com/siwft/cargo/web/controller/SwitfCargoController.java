package com.siwft.cargo.web.controller;

import com.siwft.cargo.service.SwiftCargoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
