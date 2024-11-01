package com.bootcamp.demo.demo_restapi.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.controller.UserOperation;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.exception.BusinessException;
import com.bootcamp.demo.demo_restapi.exception.ErrorCode;
import com.bootcamp.demo.demo_restapi.infra.GeneralResponse;
import com.bootcamp.demo.demo_restapi.infra.SysCode;
import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.model.UserDTO;
import com.bootcamp.demo.demo_restapi.model.UserRequest;
import com.bootcamp.demo.demo_restapi.model.mapper.Mapper;
import com.bootcamp.demo.demo_restapi.model.mapper.UserMapper;
import com.bootcamp.demo.demo_restapi.service.UserService;

@RestController // @Controller + @ResponseBody
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;

  @Autowired
  private Mapper mapper;

  @Override
  public User[] getAllUsers() {
    return userService.getUsers();
  }

  @Override
  public User getUserById(String id){
    return userService.getUsers(id);
  }

  @Override
  public User createNewUser(UserRequest userForm) {
    String name = userForm.getName();
    String email = userForm.getEmail();
    String phone = userForm.getPhone();
    return mapper.map(userService.createNewUser(name, email, phone));
  }

  @Override
  public UserEntity getUsersFromDBById(Long id){
    Optional<UserEntity> userEntity = this.userService.getUserFromDB(id);
    if (userEntity.isPresent()) {
      return userEntity.get();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
  }

  @Override
  public void deleteUsersFromDBById(@PathVariable Long id) {
      this.userService.deleteById(id);
  }

  @Override
  public User modifyUser(String userid, UserRequest userRequest){
    return userService.modifyUser(userid, userRequest);
  }

  @Override
  public User updateEmail(String userid, String email) {
    return userService.updateEmail(userid, email);
  }

  @Override
  public GeneralResponse<UserDTO> getUserByUsername(String username) {
    UserEntity userEntity = this.userService.getUserByUsername(username);
    
    UserDTO userDTO = UserMapper.map(userEntity);
    return GeneralResponse.<UserDTO>builder() //
        .status(SysCode.OK) //
        .data(List.of(userDTO)) //
        .build();
  }

}