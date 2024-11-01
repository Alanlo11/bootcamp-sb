package com.bootcamp.demo_restapi2.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_restapi2.controller.BankUserOperation;
import com.bootcamp.demo_restapi2.dto.BankUserDto;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.mapper.BankMapper;
import com.bootcamp.demo_restapi2.model.UserDTO;
import com.bootcamp.demo_restapi2.service.UserService;
import com.bootcamp.demo_restapi2.util.BusinessException;
import com.bootcamp.demo_restapi2.util.ErrorCode;
import com.bootcamp.demo_restapi2.util.GeneralResponse;
import com.bootcamp.demo_restapi2.util.SysCode;

@RestController
public class BankUserController implements BankUserOperation{
  @Autowired
  private UserService userService;


  @Override
  public UserDTO[] getUsers() {
    return this.userService.getUsers();
  }

  @Override
  public UserEntity getUsersFromDBById(Long id) {
    Optional<UserEntity> userEntity = this.userService.getUserFromDB(id);
    if (userEntity.isPresent()) {
      return userEntity.get();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
  }

  @Override
  public void deleteUserFromDBById(Long id) {
    this.userService.deleteById(id);
  }

  @Override
  public GeneralResponse<BankUserDto> getUserByUsername(String username) {
    UserEntity userEntity = this.userService.getUserByUsername(username);
    
    BankUserDto bankUserDto = new BankMapper().map(userEntity);
    return GeneralResponse.<BankUserDto>builder() //
        .status(SysCode.OK) //
        .data(List.of(bankUserDto)) //
        .build();
  }
}