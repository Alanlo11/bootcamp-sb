package com.bootcamp.demo_sb_yahoo_finance.config.Scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.model.dto.StockSymbolDTO;
import com.bootcamp.demo_sb_yahoo_finance.redis.RedisHelper;
import com.bootcamp.demo_sb_yahoo_finance.service.StockPriceService;
import com.bootcamp.demo_sb_yahoo_finance.service.StockSymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AppScheduler {
  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private Mapper mapper;

  // syntax : (cron = "0 0/1 * * * ?") per minute
  // @Scheduled(cron = "0 0/5 9-16 * * MON-FRI")
  @Scheduled(fixedRate = 300_000)
  public void stockQuote() throws JsonProcessingException {

    // String[] symbol = redisHelper.get("STOCK-LIST", String[].class);
    // List<String> symbols = Arrays.stream(symbol)//
    //     .collect(Collectors.toList());
    // stockPriceService.save(symbols);

    String[] stockList = new String[] {"0388.HK", "0700.HK", "0005.HK"};
    List<StockEntity> stockEntityList = Arrays.stream(stockList)
        .map(s -> mapper.map(s)).collect(Collectors.toList());
    this.stockSymbolService.saveAll(stockEntityList);

    stockPriceService.save(Arrays.asList(stockList));
    System.out.println("Success save Stock every 5 mins");

    List<StockSymbolDTO> stocks = this.stockPriceService
    
  }
}
