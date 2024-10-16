package com.bootcamp.demo.demo_restapi.model.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.Post;
import com.bootcamp.demo.demo_restapi.model.PostDTO;
import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.model.UserPostDTO;
import lombok.Getter;

@Getter
@Component // bean
public class Mapper {
  
  // static method,but will many object when someone call
  public UserEntity map(User user){
    return UserEntity.builder()
    .name(user.getName())
    .username(user.getUsername())
    .email(user.getEmail())
    .phone(user.getPhone())
    .website(user.getWebsite())
    .build();
  }
  
  public User map(UserEntity userEntity) {
    return User.builder()//
        .name(userEntity.getName())//
        .username(userEntity.getUsername())//
        .email(userEntity.getEmail())//
        .phone(userEntity.getPhone())//
        .website(userEntity.getWebsite())//
        .build();
  }

  public PostEntity map(Post post){
    return PostEntity.builder()
    .userId(post.getUserId())
    .title(post.getTitle())
    .body(post.getBody())
    .build();
  }

  public UserPostDTO getUserPostDTO(User user){
    return UserPostDTO.builder()
    .userid(Long.valueOf(user.getId()))
    .username(user.getName())
    .useremail(user.getEmail())
    .postDTO(null)
    .build();
  }

  public PostDTO getPostDTO(Post post){
    return PostDTO.builder()
    .userId(Long.valueOf(post.getUserId()))
    .id(Long.valueOf(post.getId()))
    .title(post.getTitle())
    .body(post.getBody())
    .build();
  }

}