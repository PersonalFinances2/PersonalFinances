package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.repository.IMetaRepository;
import com.Tech.personalFinance.persistence.PerfilEntityRepository;
import com.Tech.personalFinance.persistence.entity.MetaEntity;
import com.Tech.personalFinance.persistence.entity.PerfilEntity;

@Service
public class MetaService {
    private final IMetaRepository metaRepository;
    private final PerfilEntityRepository perfilEntityRepository;

    public MetaService(IMetaRepository metaRepository, PerfilEntityRepository perfilEntityRepository){
        this.metaRepository = metaRepository;
        this.perfilEntityRepository = perfilEntityRepository;
    }

    public List<MetaEntity> getAll(){

        //Buscar Id del Usuario
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        PerfilEntity usuario = this.perfilEntityRepository.findByUsername(username);

        List<MetaEntity> meta = this.metaRepository.findByUsuarioIdUsuario(usuario.getIdUsuario());
        
        return meta;
    }

    public MetaEntity getById(Integer id){
        return this.metaRepository.getById(id);
    }

    public MetaEntity add(MetaEntity metaEntity){
        return this.metaRepository.save(metaEntity);
    }

    public MetaEntity update(Integer id, MetaEntity metaEntity){
        return this.metaRepository.update(id, metaEntity);
    }

    public MetaEntity delete(Integer id){
        return this.metaRepository.delete(id);
    }

}
