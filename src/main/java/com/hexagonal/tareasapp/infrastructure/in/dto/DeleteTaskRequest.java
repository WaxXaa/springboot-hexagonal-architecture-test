package com.hexagonal.tareasapp.infrastructure.in.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class DeleteTaskRequest {
    @NotNull
  public UUID id;
  @NotNull
  public UUID projecId;
}
