package com.bootcamp.demo_sb_yahoo_finance.redis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisHelper {
  private RedisTemplate<String, Object> redisTemplate;
  private ObjectMapper objectMapper;
  

  public RedisHelper(RedisConnectionFactory redisConnectionFactory){
    this.redisTemplate = new RedisTemplate<>();

    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    this.redisTemplate.setConnectionFactory(redisConnectionFactory);
    this.redisTemplate.setKeySerializer(RedisSerializer.string());
    this.redisTemplate.setValueSerializer(RedisSerializer.string());
    this.redisTemplate.afterPropertiesSet();
  }
  
}
