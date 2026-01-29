package com.hexagonal.tareasapp.infrastructure.out.entity;
import java.util.UUID;
import com.hexagonal.tareasapp.domain.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id",nullable = false)
    public ProjectJpaEntity project;

    public TaskJpaEntity(UUID id, String title, String description, Status status, ProjectJpaEntity project) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.project = project;
    }
    public TaskJpaEntity(){}
}