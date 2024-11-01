package com.bootcamp.demo.demo_restapi.model.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.GovUserDto;

@Component
public class GovMapper {

  public GovUserDto map(UserEntity entity) {
    return GovUserDto.builder() //
        .name(entity.getName()) //
        .email(entity.getEmail()) //
        .build();
  }
  
}