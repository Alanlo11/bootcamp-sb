package com.bootcamp.demo_sb_yahoo_finance.model;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.dto.StockSymbolDTO;

@Component
public class Mapper {

  public StockSymbolDTO map(StockEntity stockEntity) {
    return StockSymbolDTO.builder()//
        .id(stockEntity.getId())//
        .symbol(stockEntity.getSymbol())//
        .build();
  }

  public StockEntity map(String symbol) {
    return StockEntity.builder()//
        .symbol(symbol)//
        .build();
  }

}
