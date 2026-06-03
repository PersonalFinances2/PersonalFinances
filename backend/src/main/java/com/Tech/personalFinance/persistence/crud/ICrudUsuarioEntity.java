package com.Tech.personalFinance.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.Tech.personalFinance.persistence.entity.UsuarioEntity;

public interface ICrudUsuarioEntity extends CrudRepository<UsuarioEntity, Integer> {

}
