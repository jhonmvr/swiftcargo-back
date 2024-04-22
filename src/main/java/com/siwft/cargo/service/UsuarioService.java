package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.Usuario;
import com.siwft.cargo.persistence.repository.UsuarioRepository;
import com.siwft.cargo.service.imp.GenericServiceImp;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService  extends GenericServiceImp<Usuario, Integer, UsuarioRepository> {
}
