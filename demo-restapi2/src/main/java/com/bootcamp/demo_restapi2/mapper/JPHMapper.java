package com.bootcamp.demo_restapi2.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_restapi2.entity.CompanyEntity;
import com.bootcamp.demo_restapi2.entity.PostEntity;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.model.Post;
import com.bootcamp.demo_restapi2.model.PostDTO;
import com.bootcamp.demo_restapi2.model.UserDTO;

@Component
public class JPHMapper {
  public UserEntity map(UserDTO user) {
    return UserEntity.builder() //
        .id(Long.valueOf(user.getId())) //
        .name(user.getName()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .username(user.getUsername()) //
        .website(user.getWebsite()) //
        .build();
  }

  public PostEntity map(PostDTO postDTO) {
    return PostEntity.builder() //
        .title(postDTO.getTitle()) //
        .body(postDTO.getBody()) //
        .build();
  }

  public Post map(PostEntity postEntity) {
    return Post.builder() //
        .id(postEntity.getId()) //
        .title(postEntity.getTitle()) //
        .body(postEntity.getBody()) //
        .build();
  }

  public CompanyEntity map(UserDTO.CompanyDTO companyDTO) {
    return CompanyEntity.builder() //
        .catchPhrase(companyDTO.getCatchPhrase()) //
        .bs(companyDTO.getBs()) //
        .name(companyDTO.getName()) //
        .build();
  }

  public UserDTO map(UserEntity userEntity){
    return UserDTO.builder()
    .email(userEntity.getEmail())
    .id(userEntity.getId())
    .name(userEntity.getName())
    .username(userEntity.getUsername())
    .phone(userEntity.getPhone())
    .website(userEntity.getWebsite())
    .build();
  }
  
}