package com.bootcamp.demo_restapi2.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_restapi2.dto.BankUserDto;
import com.bootcamp.demo_restapi2.entity.UserEntity;

@Component
public class BankMapper {
  public BankUserDto map(UserEntity entity) {
    return BankUserDto.builder() //
        .name(entity.getName()) //
        .email(entity.getEmail()) //
        .website(entity.getWebsite()) //
        .build();
  }
}
