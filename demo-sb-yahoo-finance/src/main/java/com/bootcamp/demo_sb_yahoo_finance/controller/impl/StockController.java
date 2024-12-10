package com.bootcamp.demo_sb_yahoo_finance.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_yahoo_finance.controller.StockOperation;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.service.StockPriceService;
import com.bootcamp.demo_sb_yahoo_finance.service.StockSymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StockController implements StockOperation{
  @Autowired
  RestTemplate restTemplate;

  @Autowired
  StockPriceService stockPriceService;

  @Autowired
  StockSymbolService stockSymbolService;

  @GetMapping("/stock")
  public List<StockEntity> getAllStockSymbol() {
      return stockSymbolService.findAll();
  }

  @GetMapping("/save")
  public List<StockPrice> save(@RequestParam List<String> symbols) throws JsonMappingException, JsonProcessingException{
      return stockPriceService.save(symbols);
  }

  @Override
  public YahooStock getStocks(@RequestParam List<String> symbol) throws JsonMappingException, JsonProcessingException{
    return stockSymbolService.getStocks(symbol);
  }
  
  
}
