package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.bc_forum.controller.UserOperation;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.service.UserService;

public class UserController implements UserOperation{
  @Autowired
  private UserService userService;

  @Override
  public List<UserEntity> getAll(){
    return userService.getAll();
  }
}
