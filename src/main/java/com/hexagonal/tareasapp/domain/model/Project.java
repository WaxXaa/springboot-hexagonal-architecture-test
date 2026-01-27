package com.hexagonal.tareasapp.domain.model;

import java.security.InvalidParameterException;
import java.util.UUID;

public class Project {
    private UUID id;
    private String name;
    private String description;
    private UUID ownerId;

    public Project(String name, String description, UUID ownerId) {

        if(name == null || name.isBlank()){
            throw new InvalidParameterException("Debe Ingresar el nombre al Proyecto");
        }
        if (name.length()<3){
            throw new InvalidParameterException("EL nombre del proyecto debe tener más de 3 Caracteres");
        }
        if(ownerId == null){
            throw new InvalidParameterException("Debe tener un usuario");
        }

        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
    }
    public Project(UUID id, String name, String description, UUID ownerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getOwnerId() {
        return ownerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
