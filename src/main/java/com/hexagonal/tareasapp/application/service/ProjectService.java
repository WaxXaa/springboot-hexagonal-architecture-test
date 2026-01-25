package com.hexagonal.tareasapp.application.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.hexagonal.tareasapp.domain.exceptions.UserNotFoundException;
import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.domain.port.in.ProjectUseCase;
import com.hexagonal.tareasapp.domain.port.out.ProjectRepositoryPort;
import com.hexagonal.tareasapp.domain.port.out.UserRepositoryPort;

@Service
public class ProjectService implements ProjectUseCase {

    private final ProjectRepositoryPort projectRepo;
    private final UserRepositoryPort userRepo;

    public ProjectService(ProjectRepositoryPort projectRepo, UserRepositoryPort userRepo) {
        this.projectRepo = projectRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Project create(String name, String description, UUID ownerId) {
            if(!userRepo.userExists(ownerId)){
                throw new UserNotFoundException(ownerId);
            }
            Project project = new Project(name, description, ownerId);
            return projectRepo.save(project);

    }
    @Override
    public List<Project> listAll() {
    return projectRepo.findAll();
    }
}