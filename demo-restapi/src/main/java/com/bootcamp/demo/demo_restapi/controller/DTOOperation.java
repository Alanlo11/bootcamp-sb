package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.demo_restapi.model.UserPostDTO;


public interface DTOOperation {
  @GetMapping(value = "/userpost/{userid}/postid")
  @ResponseStatus(HttpStatus.OK)
  
  UserPostDTO getUserPostDTO(@PathVariable String userid,
  @RequestParam(defaultValue = "0", value = "postid") String postid);

}