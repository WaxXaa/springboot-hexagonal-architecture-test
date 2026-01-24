package com.hexagonal.tareasapp.domain.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(UUID id){
    super("el usuario con el id " + id + " no existe");
  }
}
