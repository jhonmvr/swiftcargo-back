package com.siwft.cargo.persistence.repository;

import com.siwft.cargo.persistence.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {
}