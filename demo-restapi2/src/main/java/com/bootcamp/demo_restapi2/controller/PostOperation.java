package com.bootcamp.demo_restapi2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo_restapi2.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostOperation {
  @GetMapping("/redis/posts")
  List<Post> getPostsFromRedis() throws JsonProcessingException; 
}