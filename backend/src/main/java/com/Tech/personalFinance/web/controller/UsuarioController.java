package com.Tech.personalFinance.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Tech.personalFinance.domain.dto.UsuarioDto;
import com.Tech.personalFinance.domain.dto.UsuarioInsertDto;
import com.Tech.personalFinance.domain.service.UsuarioService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listaUsuarios")
    @PreAuthorize("hasAnyRole('ADMIN')")
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
    
    @PostMapping("/crearUsuario")
    public ResponseEntity<UsuarioDto> add(@RequestBody UsuarioInsertDto usuarioInsertDto) {
        UsuarioDto usuarioDto = this.usuarioService.add(usuarioInsertDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Integer id, @RequestBody UsuarioInsertDto usuarioInsertDto) {
        UsuarioDto usuarioDto = this.usuarioService.update(id, usuarioInsertDto);

        if (usuarioDto == null) 
            return ResponseEntity.notFound().build();
                    
        return ResponseEntity.ok(usuarioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDto> delete(@PathVariable Integer id){
        UsuarioDto usuarioDto = this.usuarioService.delete(id);

        if (usuarioDto == null) 
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioDto);
    }
    
}
