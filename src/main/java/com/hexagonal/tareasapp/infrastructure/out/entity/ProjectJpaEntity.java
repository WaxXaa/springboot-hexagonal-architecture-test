package com.hexagonal.tareasapp.infrastructure.out.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class ProjectJpaEntity {
    @Id
    @Column
    public UUID id;

    @Column(nullable = false, unique = true)
    public String name;

    @Column
    public String description;

    @Column(nullable = false)
    public UUID ownerId;

    public ProjectJpaEntity() {
    }

    public ProjectJpaEntity(UUID id, String name, String description, UUID ownerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
    }

    
}
