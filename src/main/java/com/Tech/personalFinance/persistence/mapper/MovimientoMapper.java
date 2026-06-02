package com.Tech.personalFinance.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.Tech.personalFinance.domain.dto.MovimientoMontoDto;
import com.Tech.personalFinance.persistence.entity.MovimientoEntity;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(source = "categoria.idCategoria", target = "categoria")
    MovimientoMontoDto toDto(MovimientoEntity movimiento);

    List<MovimientoMontoDto> toDto(Iterable<MovimientoEntity> movimientoEntity);

}
