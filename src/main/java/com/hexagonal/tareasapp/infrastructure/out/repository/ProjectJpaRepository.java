package com.hexagonal.tareasapp.infrastructure.out.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.tareasapp.infrastructure.out.entity.ProjectJpaEntity;

public interface ProjectJpaRepository extends JpaRepository<ProjectJpaEntity, UUID > {
    
}
