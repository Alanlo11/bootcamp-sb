package com.bootcamp.demo.demo_restapi.service;

import com.bootcamp.demo.demo_restapi.model.Post;

public interface PostService {
  Post[] getPosts();
  Post getPost(String id);
}
