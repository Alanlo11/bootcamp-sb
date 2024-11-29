package com.bootcamp.demo_thymeleaf.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_thymeleaf.dto.CoinDto;

// @RestController (return json only)
@Controller // non-json (i.e. html)
public class CoinController {
  @Autowired
  private RestTemplate restTemplate;
  
  // 製造html出去
   @GetMapping("/coins")
  public String getCoin(Model model) {
      String url = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
      CoinDto[] coins = this.restTemplate.getForObject(url, CoinDto[].class);
      System.out.println(Arrays.toString(coins));
      model.addAttribute("coinList", coins);
      return "coin"; //return coin.html
      // return Arrays.asList(coins);
  }

}
