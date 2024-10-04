package com.bootcamp.demo.demo_sb_calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_calculator.DemoSbCalculatorApplication;

@Service
public class BeanService {
  public List<String> getBeans(){
    return Arrays.stream(DemoSbCalculatorApplication.context.getBeanDefinitionNames())
    .collect(Collectors.toList());
  }
}