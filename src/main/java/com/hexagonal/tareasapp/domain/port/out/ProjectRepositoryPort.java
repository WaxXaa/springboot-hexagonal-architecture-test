package com.hexagonal.tareasapp.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hexagonal.tareasapp.domain.model.Project;

public interface ProjectRepositoryPort {
    public Project save(Project project);
    public Optional<Project> findById(UUID id);
    public void deleteById(UUID id);
    public List<Project> findAll();
}
