package com.Tech.personalFinance.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tech.personalFinance.domain.repository.IMetaRepository;
import com.Tech.personalFinance.persistence.crud.ICrudMetaEntity;
import com.Tech.personalFinance.persistence.entity.MetaEntity;

@Repository
public class MetaEntityRepository implements IMetaRepository{

    private final ICrudMetaEntity crudMetaEntity;

    public MetaEntityRepository(ICrudMetaEntity crudMetaEntity){
        this.crudMetaEntity = crudMetaEntity;
    }

    @Override
    public List<MetaEntity> getAll() {
        return (List<MetaEntity>) this.crudMetaEntity.findAll();
    }

    @Override
    public MetaEntity getById(Integer id) {
        MetaEntity metaEntity = this.crudMetaEntity.findById(id).orElse(null);

        if (metaEntity == null)
            return null;
        
        return metaEntity;
    }

    @Override
    public MetaEntity save(MetaEntity meta) {
        return this.crudMetaEntity.save(meta);
    }

    @Override
    public MetaEntity update(Integer id, MetaEntity meta) {
        MetaEntity metaEntity = this.crudMetaEntity.findById(id).orElse(null);

        if (metaEntity == null)
            return null;

        return this.crudMetaEntity.save(meta);            
    }

    @Override
    public MetaEntity delete(Integer id) {
        MetaEntity metaEntity = this.crudMetaEntity.findById(id).orElse(null);

        if (metaEntity == null)
            return null;

        this.crudMetaEntity.delete(metaEntity);
        return metaEntity;
    }

}
