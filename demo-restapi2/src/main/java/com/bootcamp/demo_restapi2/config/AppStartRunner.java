package com.bootcamp.demo_restapi2.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // create a bean for AppStartRunner.class
public class AppStartRunner implements CommandLineRunner{
  // ! CommandLineRunner is used for something must be done before server starts

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Hello world!!!!");
    // throw new Exception();
  }
}
