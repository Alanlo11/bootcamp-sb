package com.bootcamp.demo.demo_restapi.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_restapi.model.Post;
import com.bootcamp.demo.demo_restapi.model.PostDTO;
import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.model.UserPostDTO;
import com.bootcamp.demo.demo_restapi.model.mapper.Mapper;
import com.bootcamp.demo.demo_restapi.service.DTOService;
import com.bootcamp.demo.demo_restapi.service.PostService;
import com.bootcamp.demo.demo_restapi.service.UserService;

@Service
public class DTOServiceHolder implements DTOService{
  
  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private Mapper mapper;

  @Override
  public UserPostDTO getUserPostDTOs(String userid,String postid){
    User user = userService.getUsers(userid);
    Post[] post = postService.getPosts();
    List<PostDTO> list = new LinkedList<>();
    UserPostDTO userPostDTO = mapper.getUserPostDTO(user);

    for (Post p : post) {
      if (Integer.valueOf(postid).equals(Integer.valueOf(0))) {
        list.add(mapper.getPostDTO(p));
      } else {
      if (p.getId().equals(Long.valueOf(postid))) {
        list.add(mapper.getPostDTO(p));
        System.out.println("DTO=" + list.toString());
        break;
      }
    }
  }
  userPostDTO.setPostDTO(list);
      return userPostDTO;
  }
  
}