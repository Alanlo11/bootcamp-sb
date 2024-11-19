package com.bootcamp.demo_restapi2.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_restapi2.mapper.JPHMapper;
import com.bootcamp.demo_restapi2.model.Post;
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

  @Autowired
  private JPHMapper jphMapper;

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
  public List<Post> getPostsFromRedis() throws JsonProcessingException {
    // Cache Pattern (Redis + DB)
    // Get from Redis
    String json = this.redisTemplate.opsForValue().get("jph-posts");
    // If not found, read from DB, and then write to Redis
    if (json == null) {
      // PostEntity to Post
      List<Post> posts = this.postRepository.findAll().stream() //
          .map(p -> this.jphMapper.map(p)) //
          .collect(Collectors.toList());
      String jsonToWrite = this.objectMapper.writeValueAsString(posts);
      this.redisTemplate.opsForValue().set("jph-posts", jsonToWrite,
          Duration.ofSeconds(30));
      return posts;
    }
    return Arrays.asList(this.objectMapper.readValue(json, Post[].class));
  }
}
