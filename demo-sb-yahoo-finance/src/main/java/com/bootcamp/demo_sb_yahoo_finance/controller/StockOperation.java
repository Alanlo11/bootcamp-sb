package com.bootcamp.demo_sb_yahoo_finance.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockOperation {
  @GetMapping(value = "/symbol")
  public YahooStock getStocks(@RequestParam List<String> symbol) throws JsonProcessingException;
}
