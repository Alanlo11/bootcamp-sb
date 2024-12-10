package com.bootcamp.demo_sb_yahoo_finance.service;

import java.util.List;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockSymbolService {
  List<StockEntity> findAll();

  void deleteAll();

  YahooStock getStocks(List<String> symbol) throws JsonProcessingException;

  List<StockEntity> saveAll(List<StockEntity> symbols);
}
