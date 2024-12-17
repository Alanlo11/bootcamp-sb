package com.bootcamp.demo_sb_yahoo_finance.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import com.bootcamp.demo_sb_yahoo_finance.infra.Yahoo.YHRestClient;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.model.YahooStock;
import com.bootcamp.demo_sb_yahoo_finance.model.line.TranType;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockPriceRepository;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockSymbolRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockPriceService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class StockPriceServiceImpl implements StockPriceService{
  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  private StockSymbolRepository stockSymbolRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private Mapper mapper;

   @Override
  public List<StockPrice> save(List<String> symbol) throws JsonProcessingException{
    YahooStock yahooStock = new YHRestClient(restTemplate).getQuote(symbol);
    List<YahooStock.QuoteBody.Result> result = yahooStock.getBody().getResult();

    List<StockEntity> stockEntities = stockSymbolRepository.findAll();
    List<StockPrice> stockPrices = result.stream().map(stock -> {
      StockPrice stockPrice = this.mapper.map(stock);
      stockPrice.setTranType(TranType.FIVE_MINUTES.getType());

      stockEntities.forEach(stockEntity -> {
        if (stockEntity.getSymbol().equals(stockPrice.getSymbol())) {
          stockPrice.setStock(stockEntity);
        }
      });
      return stockPrice;
    })
    .collect(Collectors.toList());

    stockPriceRepository.saveAll(stockPrices);

    return stockPrices;
  }

  @Override
  public Optional<StockPrice> findBySymbol(String symbol){
    return this.stockPriceRepository.findBySymbol(symbol);
  }

  @Override
  public List<StockPrice> findAll() {
    return this.stockPriceRepository.findAll();
  }
}