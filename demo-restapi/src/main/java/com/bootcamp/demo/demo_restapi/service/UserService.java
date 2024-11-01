package com.bootcamp.demo.demo_restapi.service;

import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.model.UserRequest;
import java.util.Optional;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;


public interface UserService {
  /* 
   * Get User Data from jsonholder
   */
  User[] getUsers();

  User getUsers(String id);

  // User[] getUsersFromWebSite();

  UserEntity createNewUser(String name, String email, String phone);


  Optional<UserEntity> getUserFromDB(Long id);

  void deleteById(Long id);

  User modifyUser(String userid,UserRequest userRequest);

  User updateEmail(String userid, String email);

  UserEntity getUserByUsername(String username);
}