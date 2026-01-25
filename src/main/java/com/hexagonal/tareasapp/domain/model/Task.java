package com.hexagonal.tareasapp.domain.model;


import java.security.InvalidParameterException;
import java.util.UUID;
import com.hexagonal.tareasapp.domain.enums.Status;

public class Task {
    private UUID id;
    private String title;
    private String description;
    private Status status;
    private UUID project_id;

    public Task(String title, String description, Status status, UUID project_id) {
        if(title == null || title.isBlank()){
            throw new InvalidParameterException("Debe Ingresar el nombre al Proyecto");
        }
        if (title.length()<3){
            throw new InvalidParameterException("EL nombre del proyecto debe tener más de 3 Caracteres");
        }
        if(project_id == null){
            throw new InvalidParameterException("Debe tener un proyecto");
        }
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = Status.PENDIENTE;
        this.project_id = project_id;
    }

    public Task(UUID id, String title, String description, Status status, UUID project_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.project_id = project_id;
    }

    
    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public UUID getProject_id() {
        return project_id;
    }
}
