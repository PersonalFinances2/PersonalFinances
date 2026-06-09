package com.Tech.personalFinance.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tech.personalFinance.domain.dto.MovimientoDto;
import com.Tech.personalFinance.domain.dto.MovimientoMontoDto;
import com.Tech.personalFinance.domain.repository.IMovimientoRepository;
import com.Tech.personalFinance.persistence.crud.ICrudMovimientoEntity;
import com.Tech.personalFinance.persistence.mapper.MovimientoMapper;

@Repository
public class MovimientoEntityRepository implements IMovimientoRepository{
    private final ICrudMovimientoEntity crudMovimientoEntity;
    private final MovimientoMapper movimientoMapper;

    public MovimientoEntityRepository(ICrudMovimientoEntity crudMovimientoEntity, MovimientoMapper movimientoMapper){
        this.crudMovimientoEntity = crudMovimientoEntity;
        this.movimientoMapper = movimientoMapper;
    }

    @Override
    public List<MovimientoMontoDto> findByUsuarioIdUsuario(Integer idUsuario) {
        return this.movimientoMapper.toDto(this.crudMovimientoEntity.findByUsuarioIdUsuario(idUsuario));
    }

    @Override
    public List<MovimientoDto> getMoviminetos(Integer idUsuario) {
        return this.movimientoMapper.toDtoMovimiento(this.crudMovimientoEntity.findByUsuarioIdUsuario(idUsuario));
    }

}
