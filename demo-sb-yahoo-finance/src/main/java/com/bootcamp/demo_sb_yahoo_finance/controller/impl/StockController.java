package com.bootcamp.demo_sb_yahoo_finance.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_yahoo_finance.infra.YHRestClient;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooQuoteDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StockController {
  @Autowired
  RestTemplate restTemplate;

  @GetMapping(value = "/stock")
  public YahooQuoteDTO test()
      throws JsonMappingException, JsonProcessingException {
    return new YHRestClient(restTemplate).getQuote(List.of("0388.HK,0700.HK,0005.HK"));
  }

  public String getMethodName(@RequestParam String param) {
    return new String();
  }

}
