package com.bootcamp.demo_sb_yahoo_finance.model;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;

@Component
public class Mapper {
  
  public StockEntity map(String stock){
    return StockEntity.builder()
    .symbol(stock)
    .build();
  }
}
