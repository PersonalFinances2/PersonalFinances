package com.Tech.personalFinance.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tech.personalFinance.domain.dto.TipoDocumentoDto;
import com.Tech.personalFinance.domain.service.TipoDocumentoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/tipo-documento")
public class TipoDocumentoContoller {
    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoContoller(TipoDocumentoService tipoDocumentoService){
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping()
    public ResponseEntity<List<TipoDocumentoDto>> getAll() {
        return ResponseEntity.ok(this.tipoDocumentoService.getAll());
    }
    

}
