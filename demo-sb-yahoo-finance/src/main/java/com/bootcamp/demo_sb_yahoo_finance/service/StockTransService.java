package com.bootcamp.demo_sb_yahoo_finance.service;

import java.util.List;
import com.bootcamp.demo_sb_yahoo_finance.model.line.Base;
import com.bootcamp.demo_sb_yahoo_finance.model.line.PriceLine;
import com.bootcamp.demo_sb_yahoo_finance.model.line.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockTransService {
  List<Transaction> getTransOnSysDate(String symbol) throws JsonProcessingException;
  PriceLine<Base> getFiveMins (String symbol) throws JsonProcessingException;
}