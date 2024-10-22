package com.bootcamp.demo.demo_restapi.controller.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.controller.GovUserOperation;
import com.bootcamp.demo.demo_restapi.dto.GovUserDto;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.exception.BusinessException;
import com.bootcamp.demo.demo_restapi.exception.ErrorCode;
import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.service.UserService;

@RestController // @Controller + @Response
public class GovUserController implements GovUserOperation{
  @Autowired
  private UserService userService;

  // @Override
  // public User[] getUsers() {
  //   return this.userService.getUsers();
  // }

  @Override
  public UserEntity getUsersFromDBById(Long id) {
    Optional<UserEntity> userEntity = this.userService.getUsersFromDB(id);
    if (userEntity.isPresent()) {
      return userEntity.get();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
  }
  // @Override
  // public void deleteUserFromDBById(Long id) {
  //   this.userService.deleteById(id);
  // }
  
}
