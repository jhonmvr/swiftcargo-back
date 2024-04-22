package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.Envio;
import com.siwft.cargo.persistence.repository.EnvioRepository;
import com.siwft.cargo.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class EnvioService extends GenericServiceImp<Envio, Integer, EnvioRepository> {
}
