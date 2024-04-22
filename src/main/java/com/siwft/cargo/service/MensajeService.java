package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.Mensaje;
import com.siwft.cargo.persistence.repository.MensajeRepository;
import com.siwft.cargo.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class MensajeService extends GenericServiceImp<Mensaje, Integer, MensajeRepository> {
}
