package com.bootcamp.demo_sb_yahoo_finance.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_sb_yahoo_finance.controller.StockOperation;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.service.YahooStockService;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
public class StockController implements StockOperation{
  @Autowired
  private YahooStockService yahooStockService;

  @Override
  public YahooStock getStocks(List<String> symbols) throws JsonProcessingException {
    return yahooStockService.getQuote(symbols);
  }
  
}
