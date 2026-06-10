package com.Tech.personalFinance.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Tech.personalFinance.persistence.entity.MovimientoEntity;

public interface ICrudMovimientoEntity extends CrudRepository<MovimientoEntity, Integer>{

    List<MovimientoEntity> findByUsuarioIdUsuario(Integer idUsuario);

}
