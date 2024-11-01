package com.bootcamp.demo.demo_restapi.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_restapi.infra.Scheme;
import com.bootcamp.demo.demo_restapi.infra.UrlManager;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.model.Post;
import com.bootcamp.demo.demo_restapi.model.mapper.Mapper;
import com.bootcamp.demo.demo_restapi.repository.PostRepository;
import com.bootcamp.demo.demo_restapi.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostSerivceHolder implements PostService{

  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.posts}")
  private String endpoint;

  // @Autowired
  // private RedisTemplate<String,String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public Post[] getPosts(){
  String url = UrlManager.builder()
        .scheme(Scheme.HTTPS)
        .domain(this.domain)
        .endpoint(this.endpoint)
        .build()
        .toString();

    Post[] posts = this.restTemplate.getForObject(url, Post[].class);

    if(postRepository.findAll().size() == 0){
    Arrays.asList(posts).stream()
    .forEach(post -> {
      PostEntity postsEntity = mapper.map(post);
      postRepository.save(postsEntity);
    });
  } else {
    System.out.println("Post Alredy have data");
  }
    return posts;
  }

  @Override
  public Post getPost(String id){
    return Arrays.stream(this.getPosts())
    .filter(post -> post.getId().equals(Long.valueOf(id)))
    .findFirst()
    .get();
  }

  
  // @Override
  // public String getPost(String id){
  //   Post[] temp = getPosts();
  //   try {
  //     for (Post p : temp) {
  //       if (Integer.valueOf(id).equals(p.getId())) {
  //         return p.toString();
  //       }
  //     }
  //   } catch (NumberFormatException e) {
  //     return "Give me a number";
  //   }
  //   return new Post().toString();
  // }

  // @Override
  // public List<PostDTO> getAllPostsByUserId(Long userID){

  // }

  // @Override
  // public List<PostEntity> getPostFromDB() throws JsonProcessingException {
  //   // Cache Pattern (Redis + DB)
  //   // Get from Redis
  //   String json = this.redisTemplate.opsForValue().get("jph-posts");
  //   if(json == null){
  //     List<PostEntity> postEntities = this.postRepository.findAll();
  //     String jsonToWrite = this.objectMapper.writeValueAsString(postEntities);
  //     this.redisTemplate.opsForValue().set("jph-posts", jsonToWrite, Duration.ofSeconds(15));
  //     return postEntities;
  //   }
  //   return Arrays.asList(this.objectMapper.readValue(json, PostEntity[].class));
  //   // If not found, read from DB, and then write to Redis
  // }
}