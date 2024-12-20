package com.bootcamp.demo_sb_yahoo_finance.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_yahoo_finance.exception.ErrorCode;
import com.bootcamp.demo_sb_yahoo_finance.exception.ErrorException;
import com.bootcamp.demo_sb_yahoo_finance.redis.RedisHelper;
import com.bootcamp.demo_sb_yahoo_finance.repository.StockTransRepository;
import com.bootcamp.demo_sb_yahoo_finance.service.SystemService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class SystemServiceImpl implements SystemService{
  @Autowired
  private StockTransRepository stockTransRepository;

  @Autowired
  private RedisHelper redisHelper;

  @Override
  public LocalDate getSysDate(String symbol) throws JsonProcessingException {
    String redisKey = "SystemDate-".concat(symbol);
    String redisSysDate = this.redisHelper.get(redisKey, String.class);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
    if(redisSysDate == null) {
      Long lastMarketTime = stockTransRepository.getMaxMarketTime(symbol);
      if(lastMarketTime == null){
        throw new ErrorException(ErrorCode.SYSDATE_NOT_READY);
      }
      LocalDate dbSysDate = Instant.ofEpochSecond(lastMarketTime.longValue()).atZone(ZoneId.systemDefault()).toLocalDate();
      this.redisHelper.set(redisKey, dbSysDate.format(format), Duration.ofMinutes(5));
      return dbSysDate;
    }
    return LocalDate.parse(redisSysDate, format);
  }
  
}
