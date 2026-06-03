package com.Tech.personalFinance.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.Tech.personalFinance.domain.dto.UsuarioDto;
import com.Tech.personalFinance.domain.dto.UsuarioInsertDto;
import com.Tech.personalFinance.persistence.entity.PerfilEntity;
import com.Tech.personalFinance.persistence.entity.RolEntity;
import com.Tech.personalFinance.persistence.entity.TipoDocumentoEntity;
import com.Tech.personalFinance.persistence.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(source = "tipoDocumento.nombre", target = "tipoDocumento")
    UsuarioDto toDto(UsuarioEntity usuarioEntity);

    List<UsuarioDto> toDto(Iterable<UsuarioEntity> usariosEntity);


    @Mapping(source = "idTipoDocumento", target = "tipoDocumento")
    @Mapping(source = "idPerfil", target = "perfil")
    @Mapping(source = "idRol", target = "rol")
    UsuarioEntity toEntity(UsuarioInsertDto usuarioInsertDto);

    @Mapping(source = "idTipoDocumento", target = "tipoDocumento")
    @Mapping(source = "idPerfil", target = "perfil")
    @Mapping(source = "idRol", target = "rol")
    void  updateEntity(UsuarioInsertDto usuarioInsertDto, @MappingTarget UsuarioEntity usuarioEntity);

    default TipoDocumentoEntity mapTipoDocumento(Integer id) {      

        TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity();
        tipoDocumento.setIdTipoDocumento(id);

        return tipoDocumento;
    }

    default PerfilEntity mapPerfil(Integer id) {

        PerfilEntity perfil = new PerfilEntity();
        perfil.setIdPerfil(id);

        return perfil;
    }

    default RolEntity mapRol(Integer id) {

        RolEntity rol = new RolEntity();
        rol.setIdRol(id);

        return rol;
    }
}
