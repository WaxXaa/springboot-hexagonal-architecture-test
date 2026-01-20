package com.hexagonal.tareasapp.infrastructure.mapper;

import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.infrastructure.out.entity.UserJpaEntity;

public class UserMapper {
  public static User entityToUser(UserJpaEntity userJpaEntity){
  return new User(userJpaEntity.name,userJpaEntity.email);
  }
  public static UserJpaEntity userToJpaEntity(User user){
    return new UserJpaEntity(user.getId(), user.getEmail(), user.getName());
  }
}

