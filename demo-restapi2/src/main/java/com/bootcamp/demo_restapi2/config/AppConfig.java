package com.bootcamp.demo_restapi2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_restapi2.util.RedisHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  RedisTemplate<String, String> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory); // 呢句好重要
    redisTemplate.setKeySerializer(RedisSerializer.string()); // key -> .string()
    redisTemplate.setValueSerializer(RedisSerializer.json()); // value -> .json()
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory redisConnectionFactory){
    return new RedisHelper(redisConnectionFactory);
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
