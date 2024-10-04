package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_calculator.controller.CatOperation;
import com.bootcamp.demo.demo_sb_calculator.model.Cat;

@Controller
@ResponseBody
public class CatController implements CatOperation{
  @Autowired
  @Qualifier(value = "peter") // 如果有多過一粒bean，打個bean名指向特定個隻先可以，得一粒bean就唔洗改名
  private Cat cat; // object address -> spring context's cat object

  @Override
  public String getCatName(){
    return this.cat.getName();
  }

  @Override
  public Cat updateCatName(String newName){
    this.cat.setName(newName);
    return this.cat;
  }
  
}