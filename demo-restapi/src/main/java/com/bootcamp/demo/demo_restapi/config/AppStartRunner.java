package com.bootcamp.demo.demo_restapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Autowired(required = false)
// private CommandLineRunner commandLineRunner;
// if (commandLineRunner != null)
//  commandLineRunner.run();

@Component // create a bean for AppStartRunner.class
public class AppStartRunner implements CommandLineRunner {
  // ! CommandLineRunner is used for something must be done before server starts

  @Override
  public void run(String... args) throws Exception{
    System.out.println("Hello World!!");
    // throw new Exception();
  }
}