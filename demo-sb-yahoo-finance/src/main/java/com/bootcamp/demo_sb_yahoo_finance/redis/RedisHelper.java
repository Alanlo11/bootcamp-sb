package com.bootcamp.demo_sb_yahoo_finance.redis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisHelper {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;
  
  public RedisHelper(RedisConnectionFactory redisConnectionFactory){
    this.redisTemplate = new RedisTemplate<>();

    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    this.redisTemplate.setConnectionFactory(redisConnectionFactory);
    this.redisTemplate.setKeySerializer(RedisSerializer.string());
    this.redisTemplate.setValueSerializer(RedisSerializer.string());
    this.redisTemplate.afterPropertiesSet();
  }

  public Object get(String key) {
    return key == null ? null : redisTemplate.opsForValue().get(key);
  }

  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException {
    Object obj = this.redisTemplate.opsForValue().get(key);
    String json = objectMapper.writeValueAsString(obj);
    return objectMapper.readValue(json, clazz);
  }
  
}
