package com.siwft.cargo.web.controller;

import com.siwft.cargo.service.UsuarioService;
import com.siwft.cargo.service.dto.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

@RequestMapping("/Auth")
@Tag(name = "SwiftCargo", description = "APi for SwiftCargo.")
public class AuthController {


    private final UsuarioService usuarioService;




    @Operation(summary = "Obtain weather query history.")
    @GetMapping("/check")
    ResponseEntity<?> check() {

        return ResponseEntity.ok(true);
    }


    @Operation(summary = "Obtain weather query history.")
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UsuarioDto usuario) {

        return ResponseEntity.ok(usuarioService.login(usuario));
    }


}

