package com.bootcamp.demo_restapi2.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.model.UserDTO;

public interface UserService {
  /**
   * Get User Data from jsonplaceholder website
   * @return
   */
  UserDTO[] getUsers();

  List<UserDTO> getUsersFromWebsite();

  /**
   * Get User Data from Database
   * @return
   */
  Optional<UserEntity> getUserFromDB(Long id);

  void deleteById(Long id);

  UserEntity getUserByUsername(String username);
}