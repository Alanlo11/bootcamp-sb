package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.bc_forum.model.UserDTO;

public interface UserOperation {
  
  @GetMapping(value = "/getall")
  List<UserDTO> getAll();

}
