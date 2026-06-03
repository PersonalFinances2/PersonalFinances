package com.Tech.personalFinance.domain.repository;

import java.util.List;

import com.Tech.personalFinance.domain.dto.UsuarioDto;
import com.Tech.personalFinance.domain.dto.UsuarioInsertDto;

public interface IUsuarioRepository {
    List<UsuarioDto> getAll(); 
    UsuarioDto getById(Integer id);
    UsuarioDto save(UsuarioInsertDto usuarioInsertDto);
    UsuarioDto update(Integer id, UsuarioInsertDto usuarioInsertDto);
    UsuarioDto delete(Integer id);
}
