package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_restapi.model.UserPostDTO;


public interface DTOOperation {
  @GetMapping(value = "/userpost/{userid}/postid")
  UserPostDTO getUserPostDTO(
    @PathVariable String userid,
    @RequestParam(defaultValue = "0") String postid
  );
}
