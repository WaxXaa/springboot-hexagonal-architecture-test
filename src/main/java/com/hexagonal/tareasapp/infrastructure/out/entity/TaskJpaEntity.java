package com.hexagonal.tareasapp.infrastructure.out.entity;

import java.util.UUID;

import com.hexagonal.tareasapp.domain.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class TaskJpaEntity {
    @Id
    @Column
    public UUID id;

    @Column(nullable = false, unique = true)
    public String title;

    @Column
    public String description;

    @Enumerated(EnumType.STRING)
    @Column
    public Status status;

    @Column(nullable = false)
    public UUID projectId;

    
}
