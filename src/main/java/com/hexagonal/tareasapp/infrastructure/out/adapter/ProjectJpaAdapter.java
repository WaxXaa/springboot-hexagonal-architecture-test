package com.hexagonal.tareasapp.infrastructure.out.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.hexagonal.tareasapp.domain.exceptions.UserNotFoundException;
import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.domain.port.out.ProjectRepositoryPort;
import com.hexagonal.tareasapp.infrastructure.mapper.ProjectMapper;
import com.hexagonal.tareasapp.infrastructure.out.entity.UserJpaEntity;
import com.hexagonal.tareasapp.infrastructure.out.repository.ProjectJpaRepository;
import com.hexagonal.tareasapp.infrastructure.out.repository.UserJpaRepository;

@Component
public class ProjectJpaAdapter implements ProjectRepositoryPort {
    private final ProjectJpaRepository projectJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public ProjectJpaAdapter(ProjectJpaRepository projectJpaRepository, UserJpaRepository userJpaRepository) {
        this.projectJpaRepository = projectJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Project save(Project project) {
        UserJpaEntity owner = userJpaRepository.findById(project.getOwnerId())
            .orElseThrow(() -> new UserNotFoundException(project.getOwnerId()));
        return ProjectMapper.entityToProject(projectJpaRepository.save(ProjectMapper.projectToJpaEntity(project, owner)));
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
