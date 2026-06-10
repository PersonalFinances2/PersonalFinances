package com.Tech.personalFinance.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.Tech.personalFinance.domain.dto.UsuarioDto;
import com.Tech.personalFinance.domain.dto.UsuarioInsertDto;
import com.Tech.personalFinance.persistence.entity.TipoDocumentoEntity;
import com.Tech.personalFinance.persistence.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(source = "tipoDocumento.nombre", target = "tipoDocumento")
    @Mapping(source = "perfil.rol.rol", target = "rol")
    UsuarioDto toDto(UsuarioEntity usuarioEntity);

    List<UsuarioDto> toDto(Iterable<UsuarioEntity> usariosEntity);


    @Mapping(source = "idTipoDocumento", target = "tipoDocumento")
    UsuarioEntity toEntity(UsuarioInsertDto usuarioInsertDto);

    @Mapping(source = "idTipoDocumento", target = "tipoDocumento")
    void  updateEntity(UsuarioInsertDto usuarioInsertDto, @MappingTarget UsuarioEntity usuarioEntity);

    default TipoDocumentoEntity mapTipoDocumento(Integer id) {      

        TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity();
        tipoDocumento.setIdTipoDocumento(id);

        return tipoDocumento;
    }
}
