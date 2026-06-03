package com.Tech.personalFinance.domain.repository;

import java.util.List;

import com.Tech.personalFinance.persistence.entity.MetaEntity;

public interface IMetaRepository {
    List<MetaEntity> getAll(); 
    MetaEntity getById(Integer id);
    MetaEntity save(MetaEntity meta);
    MetaEntity update(Integer id, MetaEntity meta);
    MetaEntity delete(Integer id);
}
