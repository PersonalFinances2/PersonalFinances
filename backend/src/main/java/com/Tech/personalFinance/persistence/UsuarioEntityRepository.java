package com.Tech.personalFinance.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tech.personalFinance.domain.dto.UsuarioDto;
import com.Tech.personalFinance.domain.dto.UsuarioInsertDto;
import com.Tech.personalFinance.domain.repository.IUsuarioRepository;
import com.Tech.personalFinance.persistence.crud.ICrudUsuarioEntity;
import com.Tech.personalFinance.persistence.entity.UsuarioEntity;
import com.Tech.personalFinance.persistence.mapper.UsuarioMapper;

@Repository
public class UsuarioEntityRepository implements IUsuarioRepository{
    private final ICrudUsuarioEntity crudUsuarioEntity;
    private final UsuarioMapper usuarioMapper;

    public UsuarioEntityRepository(ICrudUsuarioEntity crudUsuarioEntity, UsuarioMapper usuarioMapper){
        this.crudUsuarioEntity = crudUsuarioEntity;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioDto> getAll() {
        return this.usuarioMapper.toDto(this.crudUsuarioEntity.findAll());
    }

    @Override
    public UsuarioDto getById(Integer id) {
        UsuarioEntity usuarioEntity = this.crudUsuarioEntity.findById(id).orElse(null);

        if (usuarioEntity == null) 
            return null;
            
        return this.usuarioMapper.toDto(usuarioEntity);
    }

    @Override
    public UsuarioDto save(UsuarioInsertDto usuarioInsertDto) {
        UsuarioEntity usuarioEntity = this.usuarioMapper.toEntity(usuarioInsertDto);

        return this.usuarioMapper.toDto(this.crudUsuarioEntity.save(usuarioEntity));
    }

    @Override
    public UsuarioDto update(Integer id, UsuarioInsertDto usuarioInsertDto) {
        UsuarioEntity usuarioEntity = this.crudUsuarioEntity.findById(id).orElse(null);

        if (usuarioEntity == null)
            return null;
        
        this.usuarioMapper.updateEntity(usuarioInsertDto, usuarioEntity);

        return this.usuarioMapper.toDto(this.crudUsuarioEntity.save(usuarioEntity));        
    }

    @Override
    public UsuarioDto delete(Integer id) {
        UsuarioEntity usuarioEntity = this.crudUsuarioEntity.findById(id).orElse(null);

        if (usuarioEntity == null) 
            return null;
            
        this.crudUsuarioEntity.delete(usuarioEntity);
        return this.usuarioMapper.toDto(usuarioEntity);
    }

}
