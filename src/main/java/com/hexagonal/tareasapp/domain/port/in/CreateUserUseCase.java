package com.hexagonal.tareasapp.domain.port.in;

import java.util.UUID;

import com.hexagonal.tareasapp.domain.model.User;

public interface CreateUserUseCase {

  public User create(UUID id, String name, String email);

}
