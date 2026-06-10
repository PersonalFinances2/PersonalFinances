package com.Tech.personalFinance.domain.repository;

import java.util.List;

import com.Tech.personalFinance.domain.dto.MovimientoDto;
import com.Tech.personalFinance.domain.dto.MovimientoInsertDto;
import com.Tech.personalFinance.domain.dto.MovimientoMontoDto;

public interface IMovimientoRepository {
    List<MovimientoMontoDto> findByUsuarioIdUsuario(Integer idUsuario);

    List<MovimientoDto> getMoviminetos(Integer idUsuario);

    MovimientoDto save(Integer IdUsuario, MovimientoInsertDto movimientoInsertDto);
}
