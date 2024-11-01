package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;

public interface JPHOperation {
  
  @GetMapping(value = "/users")
  List<User> getUsers();

  @GetMapping(value = "/posts")
  List<Post> getPosts();

  @GetMapping(value = "/comments")
  List<Comment> getComments();

  @PostMapping(value = "/saveall")
  String saveAll();
  
}