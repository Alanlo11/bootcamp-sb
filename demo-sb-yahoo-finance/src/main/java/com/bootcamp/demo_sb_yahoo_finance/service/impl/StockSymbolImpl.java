package com.bootcamp.demo_sb_yahoo_finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.infra.Yahoo.YHRestClient;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockSymbolRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockSymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class StockSymbolImpl implements StockSymbolService{
  @Autowired
  private StockSymbolRepository stockSymbolRepository;

  @Autowired
  private YHRestClient yhRestClient;

  @Override
  public void deleteAll() {
    stockSymbolRepository.deleteAll();
  }

  @Override
  public List<StockEntity> findAll() {
    return stockSymbolRepository.findAll();
  }

  
  @Override
  public YahooStock getStocks(List<String> symbol) throws JsonProcessingException{
    return yhRestClient.getQuote(symbol);
  }

  @Override
  public List<StockEntity> saveAll(List<StockEntity> symbols){
    return stockSymbolRepository.saveAll(symbols);
  }

}