package com.bootcamp.demo_restapi2.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_restapi2.dto.GovUserDto;
import com.bootcamp.demo_restapi2.entity.UserEntity;

@Component
public class GovMapper {
  public GovUserDto map(UserEntity entity) {
    return GovUserDto.builder() //
        .name(entity.getName()) //
        .email(entity.getEmail()) //
        .build();
  }
}