package com.bootcamp.demo_restapi2.service;

import java.util.List;
import com.bootcamp.demo_restapi2.model.Post;
import com.bootcamp.demo_restapi2.model.PostDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostService {
  List<PostDTO> getPosts();

  List<Post> getPostsFromRedis() throws JsonProcessingException;
}