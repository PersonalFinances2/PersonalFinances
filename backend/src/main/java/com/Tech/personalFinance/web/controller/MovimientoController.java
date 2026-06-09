package com.Tech.personalFinance.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tech.personalFinance.domain.dto.MovimientoDto;
import com.Tech.personalFinance.domain.dto.ResumenFinancieroDto;
import com.Tech.personalFinance.domain.service.MovimientoService;


@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService){
        this.movimientoService = movimientoService;
    }

    @GetMapping()
    public ResponseEntity<ResumenFinancieroDto> getAll() {
        return ResponseEntity.ok(this.movimientoService.getAll());
    }

    @GetMapping("/movimientos")
    public ResponseEntity<List<MovimientoDto>> getmovimientos() {
        return ResponseEntity.ok(this.movimientoService.getMovimiento());
    }
    

}
