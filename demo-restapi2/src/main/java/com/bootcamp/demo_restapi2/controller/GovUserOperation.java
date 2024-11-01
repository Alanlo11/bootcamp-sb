package com.bootcamp.demo_restapi2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo_restapi2.dto.GovUserDto;
import com.bootcamp.demo_restapi2.util.GeneralResponse;

public interface GovUserOperation {
  @GetMapping(value = "/gov/db/user/{id}")
  GeneralResponse<GovUserDto> getUserFromDBById(@PathVariable Long id);

}