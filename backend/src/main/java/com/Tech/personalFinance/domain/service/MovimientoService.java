package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.dto.MovimientoMontoDto;
import com.Tech.personalFinance.domain.dto.ResumenFinancieroDto;
import com.Tech.personalFinance.domain.repository.IMovimientoRepository;
import com.Tech.personalFinance.persistence.PerfilEntityRepository;
import com.Tech.personalFinance.persistence.entity.PerfilEntity;

@Service
public class MovimientoService {
    private final IMovimientoRepository movimientoRepository;
    private final PerfilEntityRepository perfilEntityRepository;

    public MovimientoService(IMovimientoRepository movimientoRepository, PerfilEntityRepository perfilEntityRepository){
        this.movimientoRepository = movimientoRepository;
        this.perfilEntityRepository = perfilEntityRepository;
    }

    public ResumenFinancieroDto getAll(){

        //Buscar Id del Usuario
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        PerfilEntity usuario = this.perfilEntityRepository.findByUsername(username);


        List<MovimientoMontoDto> movimientos = this.movimientoRepository.findByUsuarioIdUsuario(usuario.getIdUsuario());

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
