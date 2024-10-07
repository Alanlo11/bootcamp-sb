package com.bootcamp.demo.demo_restapi.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.controller.DTOOperation;
import com.bootcamp.demo.demo_restapi.model.UserPostDTO;
import com.bootcamp.demo.demo_restapi.service.DTOService;

@RestController
public class DTOController implements DTOOperation{
  @Autowired
  private DTOService dtoService;

  @Override
  public UserPostDTO getUserPostDTO(String userid,String id){
    return dtoService.getUserPostDTOs(userid, id);
  }
}