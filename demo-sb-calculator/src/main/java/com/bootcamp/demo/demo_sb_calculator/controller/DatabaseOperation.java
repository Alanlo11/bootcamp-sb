package com.bootcamp.demo.demo_sb_calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface DatabaseOperation {
  // Read Operation
  @GetMapping(value = "/database/strings/{index}")
  String getString(@PathVariable String index);

  
  // Write Operation (Create new resource)
  @PostMapping(value = "/database/strings/{newString}")
  String addString(@PathVariable String newString);

  @GetMapping(value = "/database/strings/getstrings")
  List<String> getStrings();

  @GetMapping(value = "/database/strings/getsize")
  int getSize();
  
}