package com.bootcamp.demo_sb_yahoo_finance.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockPriceRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockPriceService;
import com.bootcamp.demo_sb_yahoo_finance.service.StockSymbolService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppRunner implements CommandLineRunner {
  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  private Mapper mapper;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Override
  public void run(String... args) throws Exception {
    this.stockSymbolService.deleteAll();
    System.out.println("Server Start...");

    redisTemplate.getConnectionFactory().getConnection().serverCommands().flushAll();
    System.out.println("Redis data clear");

    String[] stockList = new String[] {"0388.HK", "0700.HK", "0005.HK"};
    List<StockEntity> stockEntityList = Arrays.stream(stockList)
        .map(s -> mapper.map(s)).collect(Collectors.toList());
    this.stockSymbolService.saveAll(stockEntityList);
    System.out.println("Server success saving stock symbols to DB...");

    String stock = this.objectMapper.writeValueAsString(stockList);
    this.redisTemplate.opsForValue().set("stock-list", stock);

    stockPriceService.save(Arrays.asList(stockList));

    // for (String stocks : stockList) {
    //   System.out.println("STOCK= " + stocks);
    //   Optional<StockPrice> price = this.stockPriceService.findBySymbol(stocks);
    //   if(price.isPresent()){
    //     System.out.println(price.get().getMarketPrice());
    //     this.redisTemplate.opsForValue().set(stocks, String.valueOf(price.get().getMarketPrice()));
    //   }
    //   this.redisTemplate.opsForValue().set(stocks, String.valueOf("price"));
    // }

  }
}
