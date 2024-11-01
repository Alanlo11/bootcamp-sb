package com.bootcamp.demo.demo_restapi.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.controller.GovUserOperation;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.exception.BusinessException;
import com.bootcamp.demo.demo_restapi.exception.ErrorCode;
import com.bootcamp.demo.demo_restapi.infra.GeneralResponse;
import com.bootcamp.demo.demo_restapi.infra.SysCode;
import com.bootcamp.demo.demo_restapi.model.GovUserDto;
import com.bootcamp.demo.demo_restapi.model.mapper.GovMapper;
import com.bootcamp.demo.demo_restapi.service.UserService;

@RestController // @Controller + @Response
public class GovUserController implements GovUserOperation{
  @Autowired
  private UserService userService;

  @Autowired
  private GovMapper govMapper;

  @Override
  public GeneralResponse<GovUserDto> getUserFromDBById(Long id) {
    Optional<UserEntity> optUserEntity = this.userService.getUserFromDB(id);
    if (optUserEntity.isPresent()) {
      UserEntity userEntity = optUserEntity.get();
      GovUserDto govUserDto = govMapper.map(userEntity);

      return GeneralResponse.<GovUserDto>builder() //
          .status(SysCode.OK) //
          .data(List.of(govUserDto)) //
          .build();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
  }
}