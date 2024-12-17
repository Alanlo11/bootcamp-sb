package com.bootcamp.demo_sb_yahoo_finance.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockPriceService {
   
  List<StockPrice> save(List<String> symbol) throws JsonProcessingException;
  List<StockPrice> findAll();
  Optional<StockPrice> findBySymbol(String symbol);
}
