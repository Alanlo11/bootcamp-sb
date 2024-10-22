package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.demo_restapi.dto.GovUserDto;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;

public interface GovUserOperation {
  
  @GetMapping(value = "/gov/db/users/{id}")
  // GovUserDto getUsersFromDBById(@PathVariable Long id);
  UserEntity getUsersFromDBById(@PathVariable Long id);
}