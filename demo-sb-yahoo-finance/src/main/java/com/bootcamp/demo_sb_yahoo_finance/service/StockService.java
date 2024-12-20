package com.bootcamp.demo_sb_yahoo_finance.service;

import java.util.List;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.dto.StockSymbolDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockService {
  List<StockEntity> save(List<StockEntity> symbol);
  List<StockEntity> findAll();
  StockEntity findBySymbol(String symbol);
  List<StockSymbolDTO> findAllWithCache() throws JsonProcessingException;

}
