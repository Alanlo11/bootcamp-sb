package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CalculatorController {
  
  @GetMapping(value = "/sum/{a}/{b}")
  public int sum(@PathVariable(value = "b") int x,
      @PathVariable(value = "a") int y) {
    System.out.println("x=" + x + ", y=" + y);
    return x + y;
  }

  @GetMapping(value = "/divide/{x}/{y}")
  public String divide(@PathVariable int x, @PathVariable int y) {
    try {
      return String.valueOf(x / y);
    } catch (ArithmeticException e) {
      return "Not Support / by zero";
    }
  }

  @GetMapping(value = "/subtract/{x}/{y}")
  public String subtract(@PathVariable String x, @PathVariable String y) { // auto-box
    try {
      return String.valueOf(Long.parseLong(x) - Long.parseLong(y));
    } catch (NumberFormatException e ) {
      return "The input params should be a number.";
    }
  }
}
