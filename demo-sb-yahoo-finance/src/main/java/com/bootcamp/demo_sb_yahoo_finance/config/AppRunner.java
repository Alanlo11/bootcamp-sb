package com.bootcamp.demo_sb_yahoo_finance.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.service.StockSymbolService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppRunner implements CommandLineRunner{
  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private Mapper mapper;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

   @Override
  public void run(String... args) throws Exception {
    this.stockSymbolService.deleteAll();
    System.out.println("Server Start...");
    String[] stockList = new String[]{"0388.HK", "0700.HK" , "0005.HK"};
    List<StockEntity> stockEntityList = Arrays.stream(stockList)
    .map(s -> mapper.map(s))
    .collect(Collectors.toList());
    this.stockSymbolService.saveAll(stockEntityList);
    System.out.println("Server success saving stock symbols...");

    redisTemplate.getConnectionFactory().getConnection().serverCommands().flushAll();
    
      String stock = this.objectMapper.writeValueAsString(stockList);
      this.redisTemplate.opsForValue().set("stock-list", stock);
  }
  
}