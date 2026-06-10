package com.Tech.personalFinance.domain.repository;

import com.Tech.personalFinance.persistence.entity.PerfilEntity;

public interface IPerfilRepositoryUser {
        PerfilEntity findByUsername(String username);
}
