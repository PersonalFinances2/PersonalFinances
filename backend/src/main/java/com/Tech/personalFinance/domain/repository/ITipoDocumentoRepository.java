package com.Tech.personalFinance.domain.repository;

import java.util.List;

import com.Tech.personalFinance.domain.dto.TipoDocumentoDto;

public interface ITipoDocumentoRepository {
    List<TipoDocumentoDto> getAll();
}
