package com.Tech.personalFinance.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.Tech.personalFinance.domain.dto.TipoDocumentoDto;
import com.Tech.personalFinance.persistence.entity.TipoDocumentoEntity;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper {

    List<TipoDocumentoDto> toDto(Iterable<TipoDocumentoEntity> tipoDocumentoEntity);

}
