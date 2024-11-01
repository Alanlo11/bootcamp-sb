package com.bootcamp.demo.demo_restapi.model.mapper;

import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.User;

public class JPHMapper {
  public static UserEntity map(User user) {
    return UserEntity.builder() //
      .id(Long.valueOf(user.getId()))
      .name(user.getName())
      .email(user.getEmail())
      .phone(user.getPhone())
      .username(user.getUsername())
      .website(user.getWebsite())
      .build();
  }

}