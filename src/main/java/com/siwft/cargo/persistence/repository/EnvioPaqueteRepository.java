package com.siwft.cargo.persistence.repository;

import com.siwft.cargo.persistence.entity.EnvioPaquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioPaqueteRepository extends JpaRepository<EnvioPaquete, Integer> {
}