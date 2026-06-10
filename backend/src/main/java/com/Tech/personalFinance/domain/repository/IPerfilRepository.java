package com.Tech.personalFinance.domain.repository;

import java.util.Optional;

import com.Tech.personalFinance.persistence.entity.PerfilEntity;

public interface IPerfilRepository {

    Optional<PerfilEntity> findByUsername(String username);
}
