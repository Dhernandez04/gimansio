package com.dhernandez.gimnasio.domain.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserLoginDto implements UserDetails {
    private Long id;
    private String usuario;
    private String password;
    private Collection<? extends GrantedAuthority> autoAuthorities;

    public UserLoginDto(Long id,String usuario, String password, Collection<? extends GrantedAuthority> autoAuthorities) {
       this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.autoAuthorities = autoAuthorities;
    }

    public static UserLoginDto construir(UsuarioDto usuario) {
        Collection<GrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        return new UserLoginDto(usuario.getId(),usuario.getUsuario(),usuario.getPassword(),authority);
    }

    public Long getId() {
        return id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autoAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
