package com.bootcamp.demo_restapi2.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_restapi2.controller.GovUserOperation;
import com.bootcamp.demo_restapi2.dto.GovUserDto;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.mapper.GovMapper;
import com.bootcamp.demo_restapi2.service.UserService;
import com.bootcamp.demo_restapi2.util.BusinessException;
import com.bootcamp.demo_restapi2.util.ErrorCode;
import com.bootcamp.demo_restapi2.util.GeneralResponse;
import com.bootcamp.demo_restapi2.util.SysCode;

@RestController
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
      GovUserDto govUserDto = this.govMapper.map(userEntity);

      return GeneralResponse.<GovUserDto>builder() //
          .status(SysCode.OK) //
          .data(List.of(govUserDto)) //
          .build();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
  }
}