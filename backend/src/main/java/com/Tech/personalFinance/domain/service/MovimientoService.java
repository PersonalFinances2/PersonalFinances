package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.dto.MovimientoDto;
import com.Tech.personalFinance.domain.dto.MovimientoMontoDto;
import com.Tech.personalFinance.domain.dto.ResumenFinancieroDto;
import com.Tech.personalFinance.domain.repository.IMovimientoRepository;
import com.Tech.personalFinance.security.BuscarIdUsuario;

@Service
public class MovimientoService {
    private final IMovimientoRepository movimientoRepository;
    private final BuscarIdUsuario buscarIdUsuario;

    public MovimientoService(IMovimientoRepository movimientoRepository, BuscarIdUsuario buscarIdUsuario){
        this.movimientoRepository = movimientoRepository;
        this.buscarIdUsuario = buscarIdUsuario;
    }

    public ResumenFinancieroDto getAll(){

        //Buscar Id del Usuario
        Integer IdUsuario = this.buscarIdUsuario.getIdUsuario();

        List<MovimientoMontoDto> movimientos = this.movimientoRepository.findByUsuarioIdUsuario(IdUsuario);

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
   
   public List<MovimientoDto> getMovimiento(){
        //Buscar Id del Usuario
        Integer IdUsuario = this.buscarIdUsuario.getIdUsuario();

        List<MovimientoDto> movimientos = this.movimientoRepository.getMoviminetos(IdUsuario);

        return movimientos;
   }

}
