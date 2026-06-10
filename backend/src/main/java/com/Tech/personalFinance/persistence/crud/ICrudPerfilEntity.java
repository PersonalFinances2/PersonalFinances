package com.Tech.personalFinance.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.Tech.personalFinance.persistence.entity.PerfilEntity;

public interface ICrudPerfilEntity extends CrudRepository<PerfilEntity, Integer>{
    PerfilEntity findByUsername(String usernamesdString);    
}
