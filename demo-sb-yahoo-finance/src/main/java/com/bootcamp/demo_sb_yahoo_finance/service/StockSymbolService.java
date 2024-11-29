package com.bootcamp.demo_sb_yahoo_finance.service;

import java.util.List;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;

public interface StockSymbolService {
  List<StockEntity> findAll();

  List<StockEntity> saveAll(List<StockEntity> symbolsList);

  void deleteAll();
}
