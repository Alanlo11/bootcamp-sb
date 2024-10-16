package com.bootcamp.demo_user.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_user.controller.UserOperation;
import com.bootcamp.demo_user.model.User;
import com.bootcamp.demo_user.service.UserService;

@RestController
public class UserController implements UserOperation{
  @Autowired
  private UserService userService;
  
  @Override
  public User[] getUsers(){
    return userService.getUsers();
  }
}