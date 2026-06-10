package com.Tech.personalFinance.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.Tech.personalFinance.persistence.crud.IJpaPerfilEntity;
import com.Tech.personalFinance.persistence.entity.PerfilEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final IJpaPerfilEntity jpaPerfilEntity;

    public CustomUserDetailsService(IJpaPerfilEntity jpaPerfilEntity){
        this.jpaPerfilEntity = jpaPerfilEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PerfilEntity perfil = jpaPerfilEntity
                    .findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        
        return User.builder()
                .username(perfil.getUsername())
                .password(perfil.getContrasenia())
                .authorities("ROLE_" + perfil.getRol().getRol())
                .build();

    }

}
