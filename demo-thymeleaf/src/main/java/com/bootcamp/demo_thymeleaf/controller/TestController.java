package com.bootcamp.demo_thymeleaf.controller;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_thymeleaf.dto.CoinDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestController {
  @GetMapping("/cointest")
  public List<CoinDto> getFakeCoin() {
      return Arrays.asList(new CoinDto());
  }

  
}
