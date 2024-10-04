package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
  @GetMapping(value = "/getbeans")
  List<String> getBeans();
}