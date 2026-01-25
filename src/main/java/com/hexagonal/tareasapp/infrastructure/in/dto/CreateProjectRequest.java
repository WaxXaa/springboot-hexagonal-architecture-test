package com.hexagonal.tareasapp.infrastructure.in.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateProjectRequest {
  @NotBlank
  public String name;
  @NotBlank
  public String description;
  @NotNull
  public UUID ownerid;
}