package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_calculator.controller.DatabaseOperation;
import com.bootcamp.demo.demo_sb_calculator.model.Database;
import com.bootcamp.demo.demo_sb_calculator.service.DatabaseService;


// ! Normally, Controller layer autowired service layer
@Controller
@ResponseBody
public class DatabaseController implements DatabaseOperation{

  @Autowired
  private DatabaseService databaseService;

  // 用個陣要autowired
  // Task1: get all strings from the array
  // Task2: get database size

  @Override
  public List<String> getStrings() {
    return Arrays.stream(databaseService.getStrings())
    .collect(Collectors.toList());
  }

  @Override
  public int getSize(){
    return databaseService.getSize();
  }


  @Override
  public String getString(String index) {
    boolean isIndexValid = true;
    int idx = -1;
    try {
      idx = Integer.valueOf(index);
    } catch (NumberFormatException e) {
      isIndexValid = false;
    }
    if (idx < 0 || idx > Database.size() - 1) {
      isIndexValid = false;
    }
    return isIndexValid ? databaseService.getString(idx)
        : "Invalid Input, please try again later.";
  }

  @Override
  public String addString(String newString){
    return databaseService.addString(newString);
  }

}
