package com.bootcamp.demo_sb_yahoo_finance.config.Scheduler;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockTransEntity;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.model.dto.StockSymbolDTO;
import com.bootcamp.demo_sb_yahoo_finance.model.line.TranType;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockTransRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockService;
import com.bootcamp.demo_sb_yahoo_finance.service.YahooStockService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class AppScheduler {
  // @Autowired
  // private RedisTemplate<String, String> redisTemplate;

  // @Autowired
  // private ObjectMapper objectMapper;

  @Autowired
  private Mapper mapper;

  @Autowired
  private YahooStockService yahooStockService;

  @Autowired
  private StockService stockService;

  @Autowired
  private StockTransRepository stockTransRepository;

  // syntax : (cron = "0 0/1 * * * ?") per minute
  // @Scheduled(cron = "0 0/5 9-16 * * MON-FRI")
  @Scheduled(fixedRate = 300)
  public void saveStockFiveMins() throws JsonProcessingException {
    List<StockSymbolDTO> stocks = this.stockService.findAllWithCache();
    if (stocks == null || stocks.size() == 0)
    return;

    List<String> symbols = stocks.stream().map(s -> s.getSymbol()).collect(Collectors.toList());
    // String[] stockList = new String[]{"0388.HK", "0700.HK", "0005.HK"};

    YahooStock yahooStock = this.yahooStockService.getQuote(symbols);
    yahooStock.getBody().getResult().forEach(s -> {
      StockEntity stockEntity = this.stockService.findBySymbol(s.getSymbol());
      StockTransEntity stockTransEntity = this.mapper.map(s);
      stockTransEntity.setStock(stockEntity);
      stockTransEntity.setSymbol(stockEntity.getSymbol());
      stockTransEntity.setId(stockEntity.getId());
      stockTransEntity.setTranType(TranType.FIVE_MINUTES.getType());
      this.stockTransRepository.save(stockTransEntity);
    });

  }
}
