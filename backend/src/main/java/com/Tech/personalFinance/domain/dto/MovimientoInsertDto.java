package com.Tech.personalFinance.domain.dto;

import java.time.LocalDate;

public record MovimientoInsertDto(
    String titulo,

    String descripcion,

    Double monto,

    LocalDate fecha,

    Integer idCategoria
) {

}
