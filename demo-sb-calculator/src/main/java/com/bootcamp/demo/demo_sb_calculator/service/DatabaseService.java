package com.bootcamp.demo.demo_sb_calculator.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_calculator.model.Database;

@Service // Component -> bean
public class DatabaseService {

  public String addString(String newString){
    return Database.addString(newString);
  }
  
  public String getString(int index){
    return Database.getString(index);
  }
}