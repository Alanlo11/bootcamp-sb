package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.demo_restapi.model.Post;

public interface PostOperation {
  @GetMapping(value = "/posts")
  Post[] getPosts();

  @GetMapping(value = "/posts/{id}")
  Post getPost(@PathVariable String id);

  // @PostMapping(value = "/create/post") // CREATE -> 0 to 1
  // @ResponseStatus(HttpStatus.CREATED)
  // Post createNewUser(@PathVariable String userID , @RequestBody NewPost newPost);

  // PutMapping -> update the row of database -> by id find something, than modify

  // PatchMapping

}