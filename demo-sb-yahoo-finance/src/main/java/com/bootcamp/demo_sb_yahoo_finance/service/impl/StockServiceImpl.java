package com.bootcamp.demo_sb_yahoo_finance.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.exception.ErrorCode;
import com.bootcamp.demo_sb_yahoo_finance.exception.ErrorException;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.model.dto.StockSymbolDTO;
import com.bootcamp.demo_sb_yahoo_finance.redis.RedisHelper;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class StockServiceImpl implements StockService{
  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private Mapper mapper;

  @Override
  public List<StockEntity> findAll() {
    return this.stockRepository.findAll();
  }

  @Override
  public StockEntity findBySymbol(String symbol) {
    return this.stockRepository.findBySymbol(symbol).orElseThrow(
      () -> new ErrorException(ErrorCode.Entity_NOT_FOUND)
    );
  }

  @Override
  public List<StockEntity> save(List<StockEntity> symbols) {
    return this.stockRepository.saveAll(symbols);
  }

  @Override
  public List<StockSymbolDTO> findAllWithCache() throws JsonProcessingException {
    StockSymbolDTO[] redisStocks = this.redisHelper.get("stock-list", StockSymbolDTO[].class);
    if (redisStocks == null) {
      List<StockSymbolDTO> dbStocks = this.stockRepository.findAll().stream().map(s -> 
      this.mapper.map(s)).collect(Collectors.toList());
      this.redisHelper.set("stock-list", dbStocks, Duration.ofMinutes(10));
      return dbStocks;
    }
    return Arrays.asList(redisStocks);
  }
  
}