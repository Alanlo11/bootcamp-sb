package com.bootcamp.demo_restapi2.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_restapi2.entity.PostEntity;
import com.bootcamp.demo_restapi2.model.PostDTO;
import com.bootcamp.demo_restapi2.repository.PostRepository;
import com.bootcamp.demo_restapi2.service.PostService;
import com.bootcamp.demo_restapi2.util.UrlManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostServiceImpl implements PostService{
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint.posts}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public List<PostDTO> getPosts() {
    String url = UrlManager.builder() //
        .domain(this.domain) //
        .endpoint(this.endpoint) //
        .build() //
        .toUriString();

    System.out.println("url=" + url); // debug
    PostDTO[] postDTOs = this.restTemplate.getForObject(url, PostDTO[].class);
    return Arrays.asList(postDTOs);
  }

  @Override
  public List<PostEntity> getPostsFromDB() throws JsonProcessingException {
    // Cache Pattern (Redis + DB)
    // Get from Redis
    String json = this.redisTemplate.opsForValue().get("jph-posts");
    // If not found, read from DB, and then write to Redis
    if (json == null) {
      List<PostEntity> postEntities = this.postRepository.findAll();
      String jsonToWrite = this.objectMapper.writeValueAsString(postEntities);
      this.redisTemplate.opsForValue().set("jph-posts", jsonToWrite, Duration.ofSeconds(30));
      return postEntities;
    }
    return Arrays.asList(this.objectMapper.readValue(json, PostEntity[].class));
  }
}