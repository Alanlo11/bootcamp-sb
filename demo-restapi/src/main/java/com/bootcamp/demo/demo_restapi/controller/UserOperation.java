package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.infra.GeneralResponse;
import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.model.UserDTO;
import com.bootcamp.demo.demo_restapi.model.UserRequest;

// frontend同controller 溝通
// 1. PathVariable
// 2. RequsetParam
// 3. RequestBody
public interface UserOperation {
  @GetMapping(value = "/users") // 查詢
  User[] getAllUsers();

  @GetMapping(value = "/users/id")
  User getUserById(@RequestParam String id);

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
  User modifyUser(@PathVariable String userid, @RequestBody UserRequest userRequest);
  // {
  // "username" : "Test"
  // "email" : "Test"
  // "phone" : "Test"
  // }

  // @PatchMapping // 改column
  @PatchMapping("/user/{userID}/email") // /user/1/email@email.com"
  @ResponseStatus(HttpStatus.ACCEPTED)
  User updateEmail(@PathVariable String userid, @RequestParam String email);

  @GetMapping(value = "/user")
  GeneralResponse<UserDTO> getUserByUsername(@RequestParam String username);
  // Controller Layer: Convert UserEntity -> User -> GeneralResponse<User>

  // @DeleteMapping // delete

  // @GetMapping(value = "/user")
  // GeneralResponse<User> getUserByUserName(@RequestParam("username") String username);
  // Controller Layer: Convert UserEntity -> User -> GeneralRespone<User>
}