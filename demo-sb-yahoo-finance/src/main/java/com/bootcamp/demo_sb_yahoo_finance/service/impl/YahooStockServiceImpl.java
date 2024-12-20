package com.bootcamp.demo_sb_yahoo_finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_yahoo_finance.infra.Yahoo.YHRestClient;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.service.YahooStockService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class YahooStockServiceImpl implements YahooStockService{
  @Autowired
  private YHRestClient yhRestClient;

  @Override
  public YahooStock getQuote(List<String> symbols)
      throws JsonProcessingException {
    return yhRestClient.getQuote(symbols);
  }
  
}
