package com.hexagonal.tareasapp.domain.port.in;

import java.util.UUID;

import com.hexagonal.tareasapp.domain.model.Project;

public interface CreateProjectUseCase {
    public Project create(String name, String description, UUID ownerId);
}
