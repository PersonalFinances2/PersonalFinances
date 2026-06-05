package com.Tech.personalFinance.domain.dto;

public record UsuarioInsertDto(

    String nombre,

    String apellido,

    Integer idTipoDocumento,

    String documento,

    String username,

    String contrasenia

    //Integer idRol

) {}
