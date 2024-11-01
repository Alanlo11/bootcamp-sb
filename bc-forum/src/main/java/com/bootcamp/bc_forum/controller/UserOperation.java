package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.bc_forum.entity.UserEntity;

public interface UserOperation {
  
  @GetMapping(value = "/getall")
  List<UserEntity> getAll();

  @GetMapping(value = "/getUserCommentById")
  List<UserCommentDTO> getUserCommentById(@RequestParam String id);
}
