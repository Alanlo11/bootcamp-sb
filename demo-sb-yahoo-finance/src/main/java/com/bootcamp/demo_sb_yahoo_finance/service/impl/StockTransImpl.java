package com.bootcamp.demo_sb_yahoo_finance.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.model.line.Base;
import com.bootcamp.demo_sb_yahoo_finance.model.line.PriceLine;
import com.bootcamp.demo_sb_yahoo_finance.model.line.Transaction;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockTransRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockService;
import com.bootcamp.demo_sb_yahoo_finance.service.StockTransService;
import com.bootcamp.demo_sb_yahoo_finance.service.SystemService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class StockTransImpl implements StockTransService{
  @Autowired
  private StockService stockService;

  @Autowired
  private StockTransRepository stockTransRepository;

  @Autowired
  private Mapper mapper;

  @Autowired
  private SystemService systemService;

  @Override
  public List<Transaction> getTransOnSysDate(String symbol) throws JsonProcessingException {
    LocalDate sysDate = systemService.getSysDate(symbol);
    long startEpoch = sysDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
    long endEpoch = sysDate.atTime(LocalTime.MAX).toEpochSecond(ZoneOffset.UTC);
    return this.stockTransRepository.findBySymbol(symbol, startEpoch, endEpoch) //
    .stream() //
    .map(e -> this.mapper.map(e)) //
    .collect(Collectors.toList());
  }

  @Override
  public PriceLine<Base> getFiveMins(String symbol) throws JsonProcessingException {
    List<Transaction> transactions = getTransOnSysDate(symbol);
    StockEntity stockEntity = this.stockService.findBySymbol(symbol);
    return 
  }

}