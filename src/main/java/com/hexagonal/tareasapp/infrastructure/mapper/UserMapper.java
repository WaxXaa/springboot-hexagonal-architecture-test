package com.hexagonal.tareasapp.infrastructure.mapper;

import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.infrastructure.out.entity.UserJpaEntity;

public class UserMapper {
  public static User entityToUser(UserJpaEntity userJpaEntity) {
    return new User(userJpaEntity.id,userJpaEntity.name, userJpaEntity.email);
  }

  public static UserJpaEntity userToJpaEntity(User user) {
    UserJpaEntity entity = new UserJpaEntity();
    entity.id = user.getId();
    entity.email = user.getEmail();
    entity.name = user.getName();
    // No asignamos el ID, dejamos que JPA lo genere
    return entity;
  }
}
