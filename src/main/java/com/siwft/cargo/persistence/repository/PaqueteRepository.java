package com.siwft.cargo.persistence.repository;

import com.siwft.cargo.persistence.entity.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {
}