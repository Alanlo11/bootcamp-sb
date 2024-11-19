package com.bootcamp.demo_sb_yahoo_finance.config;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_sb_yahoo_finance.redis.RedisHelper;

@Configuration
public class AppConfig {
  @Bean
  Redis redis() {
    return new Redis();
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory redisConnectionFactory) {
    return new RedisHelper(redisConnectionFactory);
  }

}
