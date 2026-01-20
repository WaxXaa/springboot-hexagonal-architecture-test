package com.hexagonal.tareasapp.domain.model;

import java.security.InvalidParameterException;
import java.util.UUID;

public class User {
  private UUID id;
  private String name;
  private String email;

  public User(String name, String email) {
    if (name != "" || email != "") {
      throw new InvalidParameterException("el nombre y el email no pueden estar vacios");
    } else if (name.length() < 5) {
      throw new InvalidParameterException("el nombre debe tener mas de 5 caracteres");
    } else if (email.indexOf('@') == -1) {
      throw new InvalidParameterException("el email debe ser valido");
    }
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

}
