package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.Paquete;
import com.siwft.cargo.persistence.repository.PaqueteRepository;
import com.siwft.cargo.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class PaqueteService extends GenericServiceImp<Paquete, Integer, PaqueteRepository> {
}
