package com.bootcamp.demo_sb_yahoo_finance.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_yahoo_finance.controller.StockOperation;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.infra.Yahoo.YHRestClient;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.service.StockPriceService;
import com.bootcamp.demo_sb_yahoo_finance.service.StockSymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StockController implements StockOperation{
  @Autowired
  RestTemplate restTemplate;

  @Autowired
  StockPriceService stockPriceService;

  @Autowired
  StockSymbolService stockSymbolService;

  @GetMapping(value = "/stock")
  public YahooStock test()
      throws JsonMappingException, JsonProcessingException {
    return new YHRestClient(restTemplate).getQuote(List.of("0388.HK,0700.HK,0005.HK"));
  }

  @GetMapping("/symbols")
  public List<StockEntity> getAllStockSymbol() {
      return stockSymbolService.findAll();
  }
  
}
