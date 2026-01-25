package com.hexagonal.tareasapp.infrastructure.out.adapter;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.domain.port.out.UserRepositoryPort;
import com.hexagonal.tareasapp.infrastructure.mapper.UserMapper;
import com.hexagonal.tareasapp.infrastructure.out.repository.UserJpaRepository;


@Component
public class UserJpaAdapter implements UserRepositoryPort {

  private final UserJpaRepository userJpaRepository;

  public UserJpaAdapter(UserJpaRepository userJpaRepository) {
    this.userJpaRepository = userJpaRepository;
  }

  @Override
  public User save(User user) {
    return UserMapper.entityToUser(userJpaRepository.save(UserMapper.userToJpaEntity(user)));
  }

  @Override
  public List<User> getAll() {
    return userJpaRepository.findAll().stream().map(entity -> UserMapper.entityToUser(entity)).toList();
  }

  @Override
  public boolean userExists(UUID id) {
    return userJpaRepository.existsById(id);
  }
}
