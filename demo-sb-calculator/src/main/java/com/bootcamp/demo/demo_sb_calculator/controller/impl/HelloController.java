package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@ResponseBody
public class HelloController {
  
  @GetMapping(value = "/hello")
  public String greeting() {
      return "Hello";
  }
  
}
