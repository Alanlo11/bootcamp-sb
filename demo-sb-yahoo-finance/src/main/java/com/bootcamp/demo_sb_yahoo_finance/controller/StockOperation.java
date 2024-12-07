package com.bootcamp.demo_sb_yahoo_finance.controller;

import java.util.List;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StockOperation {

  YahooStock test() throws JsonMappingException, JsonProcessingException;

  List<StockEntity> getAllStockSymbol();
}
