package com.bootcamp.demo.demo_restapi.model.mapper;

import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.UserDTO;

public class UserMapper {
  public static UserDTO map(UserEntity userEntity){
    return UserDTO.builder()
    .name(userEntity.getName())
    .email(userEntity.getEmail())
    .website(userEntity.getWebsite())
    .build();
  }
}
