package com.hexagonal.tareasapp.domain.port.in;

import com.hexagonal.tareasapp.domain.model.User;

public interface CreateUserUseCase {

  public User create(String name, String email);

}
