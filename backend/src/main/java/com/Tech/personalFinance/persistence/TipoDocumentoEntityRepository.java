package com.Tech.personalFinance.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tech.personalFinance.domain.dto.TipoDocumentoDto;
import com.Tech.personalFinance.domain.repository.ITipoDocumentoRepository;
import com.Tech.personalFinance.persistence.crud.ICrudTipoDocumentoEntity;
import com.Tech.personalFinance.persistence.mapper.TipoDocumentoMapper;

@Repository
public class TipoDocumentoEntityRepository implements ITipoDocumentoRepository{
    private final ICrudTipoDocumentoEntity crudTipoDocumentoEntity;
    private final TipoDocumentoMapper tipoDocumentoMapper;

    public TipoDocumentoEntityRepository(ICrudTipoDocumentoEntity crudTipoDocumentoEntity, 
                                        TipoDocumentoMapper tipoDocumentoMapper){
        this.crudTipoDocumentoEntity = crudTipoDocumentoEntity;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
    }

    @Override
    public List<TipoDocumentoDto> getAll() {
        return this.tipoDocumentoMapper.toDto(this.crudTipoDocumentoEntity.findAll());
    }

}
