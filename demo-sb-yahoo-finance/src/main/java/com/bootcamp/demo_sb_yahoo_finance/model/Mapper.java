package com.bootcamp.demo_sb_yahoo_finance.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import com.bootcamp.demo_sb_yahoo_finance.model.dto.StockSymbolDTO;
import com.bootcamp.demo_sb_yahoo_finance.model.line.Point;

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

  public StockPrice map(YahooStock.QuoteBody.Result result) {
    LocalDateTime time = LocalDateTime //
        .ofInstant(Instant.ofEpochSecond(result.getRegularMarketTime()), //
            ZoneId.systemDefault());

    return StockPrice.builder() //
        .symbol(result.getSymbol()) //
        .ask(result.getAsk()) //
        .markDateTime(time) //
        .marketPrice(result.getRegularMarketPrice()) //
        .marketPriceChangePercent(result.getRegularMarketChangePercent()) //
        .marketUnixTime(result.getRegularMarketTime()) //
        .tranDateTime(LocalDateTime.now()) //
        .askSize(result.getAskSize()) //
        .bid(result.getBid()) //
        .bidSize(result.getBidSize()) //
        .build();
  }

}
