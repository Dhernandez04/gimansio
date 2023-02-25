package com.dhernandez.gimnasio.web.controller;

import com.dhernandez.gimnasio.domain.dto.*;
import com.dhernandez.gimnasio.domain.service.EmailService;
import com.dhernandez.gimnasio.domain.service.UserDetailServiceImp;
import com.dhernandez.gimnasio.domain.service.UsuarioService;
import com.dhernandez.gimnasio.domain.utils.Helper;
import com.dhernandez.gimnasio.web.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImp userDetailServiceImplement;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtProvider jwtUtil;
    @Autowired
    EmailService emailService;



    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody UsuarioInDto usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setUsuario(Helper.cadenaAleatoria(8));
        UsuarioDto usuarioDto = usuarioService.guardar(usuario);
        EmailBody email = new EmailBody();
        email.setEmail(usuarioDto.getEmail());
        email.setSubject("Credenciales de acceso");
        email.setContent("El usuario de acceso para ingresar al sistema es el siguiente: "+usuarioDto.getUsuario()+"\n"+"Por favor no responder este mensaje!1");
        emailService.sendEmail(email);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getPassword()));
            UserLoginDto userDetails = (UserLoginDto) userDetailServiceImplement.loadUserByUsername(request.getUsuario());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt,userDetails.getId()), HttpStatus.OK);
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(Collections.singletonMap("mensaje","Usuario o contraseña invalidos."),HttpStatus.FORBIDDEN);
        } catch (AuthenticationException ex){
            return new ResponseEntity<>(Collections.singletonMap("mensaje","Usuario o contraseña invalidos."),HttpStatus.FORBIDDEN);
        }
    }
}
