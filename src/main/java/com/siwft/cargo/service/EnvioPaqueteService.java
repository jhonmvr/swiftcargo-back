package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.EnvioPaquete;
import com.siwft.cargo.persistence.repository.EnvioPaqueteRepository;
import com.siwft.cargo.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class EnvioPaqueteService extends GenericServiceImp<EnvioPaquete, Integer, EnvioPaqueteRepository> {
}
