package com.bootcamp.demo.demo_restapi.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.controller.PostOperation;
import com.bootcamp.demo.demo_restapi.model.Post;
import com.bootcamp.demo.demo_restapi.service.PostService;

@RestController
public class PostController implements PostOperation{
  @Autowired
  private PostService postService;

  @Override
  public Post[] getPosts(){
    return postService.getPosts();
  }

  @Override
  public Post getPost(String id){
    return postService.getPost(id);
  }
  
  // @Override
  // public Post createNewUser(String userID ,NewPost newPost){
    
  // }
}