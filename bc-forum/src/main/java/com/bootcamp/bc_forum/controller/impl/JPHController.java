package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.controller.JPHOperation;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;
import com.bootcamp.bc_forum.service.JPHService;

@RestController
public class JPHController implements JPHOperation{

  @Autowired
  private JPHService jphService;
  
  @Override
  public List<User> getUsers(){
    return jphService.getUsers();
  }

  @Override
  public List<Post> getPosts(){
    return jphService.getPosts();
  }

  @Override
  public List<Comment> getComments(){
    return jphService.getComments();
  }

  @Override
  public String saveAll(){
    return jphService.saveAll();
  }

}