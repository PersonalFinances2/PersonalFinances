package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.repository.IMetaRepository;
import com.Tech.personalFinance.persistence.entity.MetaEntity;
import com.Tech.personalFinance.persistence.entity.UsuarioEntity;
import com.Tech.personalFinance.security.BuscarIdUsuario;

@Service
public class MetaService {
    private final IMetaRepository metaRepository;
    private final BuscarIdUsuario buscarIdUsuario;

    public MetaService(IMetaRepository metaRepository, BuscarIdUsuario buscarIdUsuario){
        this.metaRepository = metaRepository;
        this.buscarIdUsuario = buscarIdUsuario;
    }

    public List<MetaEntity> getAll(){

        //Buscar el Id del usuario 
        Integer IdUsuario = this.buscarIdUsuario.getIdUsuario();

        List<MetaEntity> meta = this.metaRepository.findByUsuarioIdUsuario(IdUsuario);
        
        return meta;
    }

    public MetaEntity getById(Integer id){
        return this.metaRepository.getById(id);
    }

    public MetaEntity add(MetaEntity metaEntity){

        //Buscar el Id del usuario 
        Integer IdUsuario = this.buscarIdUsuario.getIdUsuario();
        
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(IdUsuario);

        metaEntity.setUsuario(usuario);

        return this.metaRepository.save(metaEntity);
    }

    public MetaEntity update(Integer id, MetaEntity metaEntity){
        return this.metaRepository.update(id, metaEntity);
    }

    public MetaEntity delete(Integer id){
        return this.metaRepository.delete(id);
    }

}
