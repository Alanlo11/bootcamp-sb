package com.bootcamp.demo_restapi2.util;

import java.time.Duration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisHelper {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper; // Obj -> json / json -> Obj

  public RedisHelper(RedisConnectionFactory redisConnectionFactory){
    this.redisTemplate = new RedisTemplate<>();

    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    this.redisTemplate.setConnectionFactory(redisConnectionFactory); // 呢句好重要
    this.redisTemplate.setKeySerializer(RedisSerializer.string()); // key -> .string()
    this.redisTemplate.setValueSerializer(RedisSerializer.json()); // value -> .json()
    this.redisTemplate.afterPropertiesSet();
  }

  public void set(String key, Object object, Duration duration)
  throws JsonProcessingException{
  String jsonToWrite = this.objectMapper.writeValueAsString(object);
  this.redisTemplate.opsForValue().set(key, jsonToWrite, duration);
  }

  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException{
    String json = this.redisTemplate.opsForValue().get(key);
    return this.objectMapper.readValue(json, clazz);
  }


}
