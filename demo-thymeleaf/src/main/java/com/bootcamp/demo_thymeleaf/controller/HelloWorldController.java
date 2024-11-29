package com.bootcamp.demo_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// Going to return static html page.
public class HelloWorldController {
  @GetMapping("/hello")
  public String sayHello(Model model) {
    model.addAttribute("message", "Hello World!");
      return "abc"; // abc.html
      
  }
}
