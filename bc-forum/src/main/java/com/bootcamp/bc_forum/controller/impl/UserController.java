package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.controller.UserOperation;
import com.bootcamp.bc_forum.model.Mapper;
import com.bootcamp.bc_forum.model.UserDTO;
import com.bootcamp.bc_forum.service.UserService;

@RestController
public class UserController implements UserOperation{
  @Autowired
  private UserService userService;

  @Autowired
  private Mapper mapper;

  @Override
  public List<UserDTO> getAll(){
    return userService.getAll().stream()
    .map(userEntity -> mapper.map(userEntity))
    .collect(Collectors.toList());
  }
  
}
