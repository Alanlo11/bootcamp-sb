package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_restapi.model.User;

// frontend同controller 溝通
public interface UserOperation {
  @GetMapping(value = "/users") // 查詢
  User[] getUsers();

  @GetMapping(value = "/users/id")
  User getUsers1(@RequestParam Integer id);

  // @PostMapping //create -> 0 to 1

  // @PatchMapping //改column

  // @DeleteMapping // delete
}