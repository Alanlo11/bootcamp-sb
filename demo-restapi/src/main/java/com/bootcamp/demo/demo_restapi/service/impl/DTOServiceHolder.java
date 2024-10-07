package com.bootcamp.demo.demo_restapi.service.impl;

import java.util.ArrayList;
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
  public UserPostDTO getUserPostDTOs(String userid,String id){
    User[] user = userService.getUsers();
    Post[] post = postService.getPosts();
    UserPostDTO dto = new UserPostDTO();
    List<PostDTO> ddd = new LinkedList<>();
    for(User u : user){
      if(u.getId().equals(Integer.valueOf(userid))) {
      dto.setUserid(Long.valueOf(u.getId()));
      dto.setUsername(u.getName());
      dto.setUseremail(u.getEmail());
        }
      }
    for (Post p : post) {
      if (p.getId().equals(Integer.valueOf(id))) {
        ddd.add(new PostDTO(Long.valueOf(p.getUserId()),Long.valueOf(p.getId()),p.getTitle(),p.getBody()));
        dto.setPostDTO(ddd);
        System.out.println(ddd.toString());
      }
    }
      return dto;
  }

}