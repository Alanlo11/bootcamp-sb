package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.demo_restapi.model.Post;

public interface PostOperation {
  @GetMapping(value = "/posts")
  Post[] getPosts();

  @GetMapping(value = "/posts/{id}")
  Post getPost(@PathVariable String id);
}
