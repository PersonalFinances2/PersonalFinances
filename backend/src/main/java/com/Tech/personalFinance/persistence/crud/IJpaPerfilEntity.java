package com.Tech.personalFinance.persistence.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tech.personalFinance.persistence.entity.PerfilEntity;

public interface IJpaPerfilEntity extends JpaRepository<PerfilEntity, Integer> {

    Optional<PerfilEntity> findByUsername(String username);
}
