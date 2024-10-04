package com.bootcamp.demo.demo_restapi.model.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.User;

@Component // bean
public class Mapper {
  
  // static method,but will many object when someone call
  public UserEntity map(User user){
    return UserEntity.builder()
    .name(user.getName())
    .username(user.getUsername())
    .email(user.getEmail())
    .phone(user.getPhone())
    .website(user.getWebsite())
    .dummy(String.valueOf(""))
    .build();
  }
}
