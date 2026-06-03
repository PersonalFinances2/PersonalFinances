package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.repository.IMetaRepository;
import com.Tech.personalFinance.persistence.entity.MetaEntity;

@Service
public class MetaService {
    private final IMetaRepository metaRepository;

    public MetaService(IMetaRepository metaRepository){
        this.metaRepository = metaRepository;
    }

    public List<MetaEntity> getAll(){
        return this.metaRepository.getAll();
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
