package com.Tech.personalFinance.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Tech.personalFinance.persistence.entity.MetaEntity;

public interface ICrudMetaEntity  extends CrudRepository<MetaEntity, Integer> {

    List<MetaEntity> findByUsuarioIdUsuario(Integer idUsuario);
    
}
