package com.hexagonal.tareasapp.domain.exceptions;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(UUID id) {
        super("el proyecto : "+id+" no existe");
    }
}
