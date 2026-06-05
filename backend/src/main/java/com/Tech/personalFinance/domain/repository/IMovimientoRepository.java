package com.Tech.personalFinance.domain.repository;

import java.util.List;

import com.Tech.personalFinance.domain.dto.MovimientoMontoDto;

public interface IMovimientoRepository {
    List<MovimientoMontoDto> findByUsuarioIdUsuario(Integer idUsuario);;
}
