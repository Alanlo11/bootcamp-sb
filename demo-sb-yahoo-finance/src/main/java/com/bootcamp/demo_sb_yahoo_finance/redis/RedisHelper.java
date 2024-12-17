package com.bootcamp.demo_sb_yahoo_finance.redis;

import java.time.Duration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisHelper {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;
  
  public RedisHelper(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper){
    this.redisTemplate = new RedisTemplate<>();

    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException {
    String serialized = redisTemplate.opsForValue().get(key);
    return serialized == null ? null
        : this.objectMapper.readValue(serialized, clazz);
  }

  public void set(String key, Object value, Duration duration)
      throws JsonProcessingException {
    String serialized = this.objectMapper.writeValueAsString(value);
    redisTemplate.opsForValue().set(key, serialized, duration);
  }
  
}
