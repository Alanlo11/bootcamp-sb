package com.bootcamp.bc_forum.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner{

  @Override
  public void run(String... args) throws Exception{
    System.out.println("Start Server : ");
    
  }
}