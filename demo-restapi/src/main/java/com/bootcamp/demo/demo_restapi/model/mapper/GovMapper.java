package com.bootcamp.demo.demo_restapi.model.mapper;

import com.bootcamp.demo.demo_restapi.dto.GovUserDto;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;

public class GovMapper {
  public static GovUserDto map(UserEntity userEntity){
    return GovUserDto.builder()
    .name(userEntity.getName())
    .email(userEntity.getEmail())
    .build();
  }
  
}
