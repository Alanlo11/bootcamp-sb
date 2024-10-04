package com.bootcamp.demo.demo_sb_calculator.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.demo.demo_sb_calculator.model.Cat;

@Configuration // Componenet
// 為左開bean
public class AppConfig { // new AppConfig()
  
  // ! @Configuration + @Bean
  @Bean(name = "john")
  Cat createCat(){
    return new Cat("John");
  }

  @Bean(name = "peter")
  Cat createCat2(){
    return new Cat("Peter");
  }
}