package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.demo_restapi.infra.GeneralResponse;
import com.bootcamp.demo.demo_restapi.model.GovUserDto;

public interface GovUserOperation {
  
  // GovUserDto getUsersFromDBById(@PathVariable Long id);
  @GetMapping(value = "/gov/db/user/{id}")
  GeneralResponse<GovUserDto> getUserFromDBById(@PathVariable Long id);
}