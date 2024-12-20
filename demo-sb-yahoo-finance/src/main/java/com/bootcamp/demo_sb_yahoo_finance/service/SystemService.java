package com.bootcamp.demo_sb_yahoo_finance.service;

import java.time.LocalDate;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface SystemService {
  LocalDate getSysDate(String symbol)throws JsonProcessingException;
}
