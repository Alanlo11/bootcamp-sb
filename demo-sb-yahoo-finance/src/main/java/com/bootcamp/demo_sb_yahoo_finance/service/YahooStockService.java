package com.bootcamp.demo_sb_yahoo_finance.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface YahooStockService {
  YahooStock getQuote(List<String> symbols) throws JsonProcessingException;

  public static void main(String[] args) {
    // LocalDateTime dateTime = LocalDateTime.of(LocalDate.of(2014, 10, 4), LocalTime.of(10, 5));
    // System.out.println(dateTime);//2014-10-04T10:05
    // System.out.println(dateTime.toEpochSecond(ZoneOffset.UTC));//1412417100

    // long epochSecond = dateTime.toEpochSecond(ZoneOffset.UTC);
    // LocalDate date = Instant.ofEpochSecond(epochSecond).atZone(ZoneId.systemDefault()).toLocalDate();
    // System.out.println(date.getYear());
    // System.out.println(date.getMonthValue());
    // System.out.println(date.getDayOfMonth());
  }
}
