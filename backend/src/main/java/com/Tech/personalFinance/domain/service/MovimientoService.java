package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.dto.MovimientoMontoDto;
import com.Tech.personalFinance.domain.dto.ResumenFinancieroDto;
import com.Tech.personalFinance.domain.repository.IMovimientoRepository;

@Service
public class MovimientoService {
    private final IMovimientoRepository movimientoRepository;

    public MovimientoService(IMovimientoRepository movimientoRepository){
        this.movimientoRepository = movimientoRepository;
    }

    public ResumenFinancieroDto getAll(){

        List<MovimientoMontoDto> movimientos = this.movimientoRepository.getAll();

        double ingresos = movimientos.stream()
                .filter(m -> m.categoria() == 1)
                .mapToDouble(MovimientoMontoDto::monto)
                .sum();

        double gastos = movimientos.stream()
                .filter(m -> m.categoria() == 2)
                .mapToDouble(MovimientoMontoDto::monto)
                .sum();

        double ahorro = ingresos - gastos;

        return new ResumenFinancieroDto(ingresos, gastos, ahorro);
   }

}
