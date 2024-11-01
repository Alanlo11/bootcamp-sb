package com.bootcamp.demo.demo_restapi.service;

import java.util.List;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostService {
  Post[] getPosts();
  Post getPost(String id);
  // List<PostDTO> getAllPostDTOs(String userid);

  // List<PostEntity> getPostFromDB() throws JsonProcessingException;
}
