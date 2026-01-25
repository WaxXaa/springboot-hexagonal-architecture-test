package com.hexagonal.tareasapp.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.hexagonal.tareasapp.domain.model.Project;

public interface ProjectUseCase {
    public Project create(String name, String description, UUID ownerId);
    public List<Project> listAll();
}
