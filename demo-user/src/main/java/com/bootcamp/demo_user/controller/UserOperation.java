package com.bootcamp.demo_user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo_user.model.User;


public interface UserOperation {
  @GetMapping(value = "/users")
  User[] getUsers();
}