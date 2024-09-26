package com.bootcamp.demo.demo_sb_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloworldController {

  // 127.0.0.1:8080/v1/hello
  // !!! Java object.greeting()
  // ctrl C
  @GetMapping(value = "/v1/hello")
  public String greeting(){
    System.out.println("this is greeting...");
    return "Hello World!!!";
  }


  @GetMapping(value = "/v1/goodbye") // path cannot be duplicated
  public String goodbye(){
    return "Goodbye";
  }
  
}