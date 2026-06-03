package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.dto.UsuarioDto;
import com.Tech.personalFinance.domain.dto.UsuarioInsertDto;
import com.Tech.personalFinance.domain.repository.IUsuarioRepository;

@Service
public class UsuarioService {
    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> getAll(){
        return this.usuarioRepository.getAll();
    }

    public UsuarioDto getById(Integer id){
        return this.usuarioRepository.getById(id);
    }

    public UsuarioDto add(UsuarioInsertDto usuarioInsertDto){
        return this.usuarioRepository.save(usuarioInsertDto);
    }

    public UsuarioDto update(Integer id,UsuarioInsertDto usuarioInsertDto){
        return this.usuarioRepository.update(id, usuarioInsertDto);
    }

    public UsuarioDto delete(Integer id){
        return this.usuarioRepository.delete(id);
    }
}
