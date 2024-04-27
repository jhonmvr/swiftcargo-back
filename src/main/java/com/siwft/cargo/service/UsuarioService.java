package com.siwft.cargo.service;

import com.siwft.cargo.persistence.entity.Usuario;
import com.siwft.cargo.persistence.repository.UsuarioRepository;
import com.siwft.cargo.service.dto.UsuarioDto;
import com.siwft.cargo.service.imp.GenericServiceImp;
import com.siwft.cargo.service.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService  extends GenericServiceImp<Usuario, Integer, UsuarioRepository> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDto login(UsuarioDto usuario) {
        if( usuario == null){
            return  null;
        }
        UsuarioDto usu = this.usuarioRepository.findUsuarioByIdentificacion(usuario.getIdentificacion());
        if(usu == null){
            return null;
        }
        if(Util.validarPassword(usu.getContrasena(),usuario.getContrasena())){
            return usu;
        }
        return null;
    }
}
