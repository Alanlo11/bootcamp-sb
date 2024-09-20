package com.bootcamp.demo.demo_sb_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloworldController {

  // !!! Java object.greeting()
  @GetMapping(value = "/v1/hello")
  public String greeting(){
    return "Hello World";
  }
  
}