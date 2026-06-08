package com.Tech.personalFinance.domain.dto;

public record UsuarioDto(
    Integer idUsuario,
    
    String nombre,

    String apellido,

    String tipoDocumento,

    String documento,

    String rol
    
) { }
