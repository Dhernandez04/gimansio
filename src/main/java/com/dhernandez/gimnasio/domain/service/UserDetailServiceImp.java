package com.dhernandez.gimnasio.domain.service;

import com.dhernandez.gimnasio.domain.dto.UserLoginDto;
import com.dhernandez.gimnasio.domain.dto.UsuarioDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImp implements UserDetailsService {
     Log Logger = LogFactory.getLog(UserDetailServiceImp.class);
    @Autowired
    UsuarioService usuarioService;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Logger.info("Incia metodo loadUserByUsername(username) "+username);
       Optional<UsuarioDto> usuarioDto = usuarioService.getByUsuario(username);
        Logger.info("Obteniendo usuario "+usuarioDto);
        Logger.info("Finaliza metodo loadUserByUsername() ");
        return UserLoginDto.construir(usuarioDto.get());
    }
}
