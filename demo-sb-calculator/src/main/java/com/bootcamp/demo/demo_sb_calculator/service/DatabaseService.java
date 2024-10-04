package com.bootcamp.demo.demo_sb_calculator.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_calculator.model.Database;

// Controller -> Service -> Database
@Service // Component -> bean 呢個class變成bean
public class DatabaseService {

  public String addString(String newString){
    return Database.addString(newString);
  }
  
  public String getString(int index){
    return Database.getString(index);
  }

  public String[] getStrings(){
    return Database.getStrings();
  }

  public int getSize(){
    return Database.getSize();
  }

}