package com.hexagonal.tareasapp.infrastructure.mapper;

import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.infrastructure.out.entity.ProjectJpaEntity;

public class ProjectMapper {
    
    public static Project entityToProject(ProjectJpaEntity projectJpaEntity){
        return new Project(projectJpaEntity.id, projectJpaEntity.name, projectJpaEntity.description, projectJpaEntity.ownerId);
    }

    public static ProjectJpaEntity projectToJpaEntity(Project project){
        ProjectJpaEntity entity = new ProjectJpaEntity();
        entity.id = project.getId();
        entity.name = project.getName();
        entity.description = project.getDescription();
        entity.ownerId = project.getOwnerId();

        return entity;
    }

}
