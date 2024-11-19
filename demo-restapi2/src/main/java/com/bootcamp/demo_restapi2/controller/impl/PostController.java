package com.bootcamp.demo_restapi2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_restapi2.controller.PostOperation;
import com.bootcamp.demo_restapi2.model.Post;
import com.bootcamp.demo_restapi2.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class PostController implements PostOperation{
  @Autowired
  private PostService postService;

  @Override
  public List<Post> getPostsFromRedis() throws JsonProcessingException {
    return postService.getPostsFromRedis();
  }
}