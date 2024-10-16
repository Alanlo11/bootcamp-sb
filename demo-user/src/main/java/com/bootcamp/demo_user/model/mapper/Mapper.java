package com.bootcamp.demo_user.model.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_user.entity.UserEntity;
import com.bootcamp.demo_user.model.User;
import lombok.Getter;

@Getter
@Component
public class Mapper {
  public UserEntity toUserEntity(User user){
    return UserEntity.builder()
    .id(user.getId())
    .name(user.getName())
    .username(user.getUsername())
    .email(user.getEmail())
    .phone(user.getPhone())
    .website(user.getWebsite())
    .build();
  }
}
