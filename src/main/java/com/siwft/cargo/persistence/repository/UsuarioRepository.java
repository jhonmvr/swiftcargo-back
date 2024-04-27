package com.siwft.cargo.persistence.repository;

import com.siwft.cargo.persistence.entity.Usuario;
import com.siwft.cargo.service.dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public UsuarioDto findUsuarioByIdentificacion(String identificacion);
}