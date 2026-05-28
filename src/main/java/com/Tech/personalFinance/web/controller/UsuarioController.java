package com.Tech.personalFinance.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Tech.personalFinance.domain.dto.UsuarioDto;
import com.Tech.personalFinance.domain.service.UsuarioService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> getAll() {
        return ResponseEntity.ok(this.usuarioService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Integer id) {
        UsuarioDto usuarioDto = this.usuarioService.getById(id);

        if (usuarioDto == null) 
            return ResponseEntity.notFound().build();
            
        return ResponseEntity.ok(usuarioDto);
    }
    
}
