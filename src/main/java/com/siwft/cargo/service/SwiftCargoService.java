package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.EnvioPaquete;
import com.siwft.cargo.persistence.entity.Paquete;
import com.siwft.cargo.persistence.repository.EnvioPaqueteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class SwiftCargoService {
    @Autowired
    private EnvioPaqueteRepository envioPaqueteRepository;
    @Autowired
    private EnvioPaqueteService envioPaqueteService;
    public void buscarPaque(Integer idPaque){
        envioPaqueteRepository.save(envioPaqueteRepository.findById(idPaque).orElse(new EnvioPaquete()));
    }

    public void buscarPaquete(Integer idPaquete){
        EnvioPaquete p = envioPaqueteService.findById( idPaquete).orElse(null);
        if(p == null ){
            return;
        }
        envioPaqueteService.save(p);

    }
}
