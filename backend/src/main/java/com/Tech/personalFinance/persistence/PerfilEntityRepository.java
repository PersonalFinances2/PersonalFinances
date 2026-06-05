package com.Tech.personalFinance.persistence;

import org.springframework.stereotype.Repository;

import com.Tech.personalFinance.domain.repository.IPerfilRepositoryUser;
import com.Tech.personalFinance.persistence.crud.ICrudPerfilEntity;
import com.Tech.personalFinance.persistence.entity.PerfilEntity;

@Repository
public class PerfilEntityRepository implements IPerfilRepositoryUser {
    
    private final ICrudPerfilEntity perfilEntity;

    public PerfilEntityRepository(ICrudPerfilEntity perfilEntity){
        this.perfilEntity = perfilEntity;
    }

    @Override
    public PerfilEntity findByUsername(String username) {

        PerfilEntity perfil = this.perfilEntity.findByUsername(username);

        return perfil;
    }

}
