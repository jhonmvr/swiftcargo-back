package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.Vehiculo;
import com.siwft.cargo.persistence.repository.VehiculoRepository;
import com.siwft.cargo.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService extends GenericServiceImp<Vehiculo, Integer, VehiculoRepository> {
}
