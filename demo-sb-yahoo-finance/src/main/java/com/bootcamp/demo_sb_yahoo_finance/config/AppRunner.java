package com.bootcamp.demo_sb_yahoo_finance.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockTransEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.model.line.TranType;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockRepository;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockTransRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockService;
import com.bootcamp.demo_sb_yahoo_finance.service.YahooStockService;

@Component
public class AppRunner implements CommandLineRunner {
  @Autowired
  private StockService stockService;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockTransRepository stockTransRepository;

  @Autowired
  private YahooStockService yahooStockService;

  @Autowired
  private Mapper mapper;

  @Override
  public void run(String... args) throws Exception {
    // 1.clear all data first
    // 2.save stock to db

    this.stockTransRepository.deleteAll();
    this.stockRepository.deleteAll();
    // String[] stockList = new String[]{"0388.HK", "0700.HK", "0005.HK"};
    // List<StockEntity> entities = Arrays.stream(stockList) //
    // .map(e -> StockEntity.builder() //
    // .symbol(e).build()) //
    // .collect(Collectors.toList());
    // stockService.save(entities);
  }

}
