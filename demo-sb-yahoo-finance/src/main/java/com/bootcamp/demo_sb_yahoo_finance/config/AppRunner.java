package com.bootcamp.demo_sb_yahoo_finance.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockRepository;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockTransRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockService;

@Component
public class AppRunner implements CommandLineRunner {
  @Autowired
  private StockService stockService;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockTransRepository stockTransRepository;

  @Override
  public void run(String... args) throws Exception {
    // 1.clear all data first
    // 2.save stock to db
    // 3.save stock and price to redis
    this.stockRepository.deleteAll();
    this.stockTransRepository.deleteAll();

    String[] stockList = new String[]{"0388.HK", "0700.HK", "0005.HK"};
    List<StockEntity> entities = Arrays.stream(stockList) //
    .map(e -> StockEntity.builder() //
    .symbol(e).build()) //
    .collect(Collectors.toList());
    stockService.save(entities);

    // YahooStock yahooStock = this.yahooStockService.getQuote(Arrays.asList(stockList));
    // yahooStock.getBody().getResult().forEach(s -> {
    //   StockEntity stockEntity = this.stockService.findBySymbol(s.getSymbol());
    //   StockTransEntity stockTransEntity = this.mapper.map(s);
    //   stockTransEntity.setStock(stockEntity);
    //   stockTransEntity.setSymbol(stockEntity.getSymbol());
    //   stockTransEntity.setId(stockEntity.getId());
    //   stockTransEntity.setTranType(TranType.FIVE_MINUTES.getType());
    //   this.stockTransRepository.save(stockTransEntity);
    // });
    
    System.out.println("Save Stock Already!");
  }

}
