package com.hexagonal.tareasapp.infrastructure.in.dto.project;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class DeleteProjectRequest {
  @NotNull
  public UUID projecId;
  @NotNull
  public UUID ownerId;
}
