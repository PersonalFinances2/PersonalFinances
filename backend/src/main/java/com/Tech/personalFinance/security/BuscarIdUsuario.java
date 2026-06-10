package com.Tech.personalFinance.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.Tech.personalFinance.persistence.PerfilEntityRepository;
import com.Tech.personalFinance.persistence.entity.PerfilEntity;

@Service
public class BuscarIdUsuario {
    private final PerfilEntityRepository perfilEntityRepository;

    public BuscarIdUsuario(PerfilEntityRepository perfilEntityRepository){
        this.perfilEntityRepository = perfilEntityRepository;
    }

    public Integer getIdUsuario(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        PerfilEntity usuario = this.perfilEntityRepository.findByUsername(username);

        return usuario.getIdUsuario();
    }   
}
