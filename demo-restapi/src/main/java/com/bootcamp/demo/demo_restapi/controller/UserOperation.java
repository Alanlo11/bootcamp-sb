package com.bootcamp.demo.demo_restapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.model.UserRequest;

// frontend同controller 溝通
// 1. PathVariable
// 2. RequsetParam
// 3. RequestBody
public interface UserOperation {
  @GetMapping(value = "/users") // 查詢
  User[] getUsers();

  @GetMapping(value = "/users/id")
  User getUsers(@RequestParam String id);

  @GetMapping(value = "/db/users/{id}")
  UserEntity getUsersFromDBById(@PathVariable Long id);

  @DeleteMapping(value = "/db/users/{id}") // duplicated? No
  void deleteUsersFromDBById(@PathVariable Long id);

  @PostMapping(value = "/create/user") //create -> 0 to 1
  @ResponseStatus(HttpStatus.CREATED)
  User createNewUser(@RequestBody UserRequest userForm);

  // @PutMapping // 改row
  // PutMapping -> update the row of database -> by id find something, than modify
  @PutMapping("/user/{userID}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  User modiUser(@RequestBody UserRequest userRequest);
  // {
  // "username" : "Test"
  // "email" : "Test"
  // "phone" : "Test"
  // }

  // @PatchMapping // 改column
  @PatchMapping("/user/{userID}") // /user/1/email@email.com"
  @ResponseStatus(HttpStatus.ACCEPTED)
  User updateEmail(@RequestParam String email);

  // @DeleteMapping // delete
}