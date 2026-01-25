package com.hexagonal.tareasapp.domain.exceptions;

import java.util.UUID;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(UUID id) {
        super ("el proyecto "+id+" no exsite");
    }
}
