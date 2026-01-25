package com.hexagonal.tareasapp.infrastructure.out.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.domain.port.out.ProjectRepositoryPort;
import com.hexagonal.tareasapp.infrastructure.mapper.ProjectMapper;
import com.hexagonal.tareasapp.infrastructure.out.entity.ProjectJpaEntity;
import com.hexagonal.tareasapp.infrastructure.out.repository.ProjectJpaRepository;

@Component
public class ProjectJpaAdapter implements ProjectRepositoryPort{
    private final ProjectJpaRepository projectJpaRepository;

    public ProjectJpaAdapter(ProjectJpaRepository projectJpaRepository) {
        this.projectJpaRepository = projectJpaRepository;
    }

    @Override
    public Project save(Project project){
        ProjectJpaEntity p = ProjectMapper.projectToJpaEntity(project);
        ProjectJpaEntity prd = projectJpaRepository.save(p);
        Project pr = ProjectMapper.entityToProject(prd);
        return pr;
    }
    
    @Override
    public Optional<Project> findById(UUID id) {
        
        return Optional.empty();
    }

    @Override
    public List<Project> findAll() {
        return projectJpaRepository.findAll().stream().map(p -> ProjectMapper.entityToProject(p)).toList();
    }

    @Override
    public void deleteById(UUID id) {
        
    }

}
