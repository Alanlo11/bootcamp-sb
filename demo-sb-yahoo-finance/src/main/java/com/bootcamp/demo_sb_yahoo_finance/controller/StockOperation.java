package com.bootcamp.demo_sb_yahoo_finance.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StockOperation {
  List<StockEntity> getAllStockSymbol();

  List<StockPrice> save(@RequestParam List<String> symbols) throws JsonMappingException, JsonProcessingException;

  YahooStock getStocks(@RequestParam List<String> symbol) throws JsonProcessingException;
}
