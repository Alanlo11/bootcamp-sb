package com.bootcamp.demo.demo_restapi.service;

import com.bootcamp.demo.demo_restapi.model.User;

public interface UserService {
  User[] getUsers();
  User getUsers1(Integer id);
}