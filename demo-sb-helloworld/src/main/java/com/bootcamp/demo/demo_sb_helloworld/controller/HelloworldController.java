package com.bootcamp.demo.demo_sb_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloworldController {

  @GetMapping(value = "/v1/hello")
  public String greeting(){
    System.out.println("This is greeting");
    return "Hello World!!!";
  }

  @GetMapping(value = "/v1/goodbye") // path cannot be duplicated
  public String goodbye(){
    return "Goodbye";
  }
  
}