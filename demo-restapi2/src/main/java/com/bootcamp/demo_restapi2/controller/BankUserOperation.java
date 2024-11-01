package com.bootcamp.demo_restapi2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_restapi2.dto.BankUserDto;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.model.UserDTO;
import com.bootcamp.demo_restapi2.util.GeneralResponse;

public interface BankUserOperation {
  @GetMapping(value = "/users")
  UserDTO[] getUsers();

  @GetMapping(value = "/db/users/{id}")
  UserEntity getUsersFromDBById(@PathVariable Long id);

  @DeleteMapping(value = "/db/users/{id}") // ! duplicated? NO
  void deleteUserFromDBById(@PathVariable Long id);

  @GetMapping(value = "/user")
  GeneralResponse<BankUserDto> getUserByUsername(@RequestParam String username);
  // Controller Layer: Convert UserEntity -> User -> GeneralResponse<User>
  
}