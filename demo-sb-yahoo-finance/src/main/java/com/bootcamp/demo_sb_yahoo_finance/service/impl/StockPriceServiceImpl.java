package com.bootcamp.demo_sb_yahoo_finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_yahoo_finance.model.Mapper;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockPriceRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.StockPriceService;
import com.bootcamp.demo_sb_yahoo_finance.service.StockSymbolService;

@Service
public class StockPriceServiceImpl implements StockPriceService{

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private Mapper mapper;

  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;


}