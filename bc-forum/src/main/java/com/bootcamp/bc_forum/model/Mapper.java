package com.bootcamp.bc_forum.model;

import org.springframework.stereotype.Component;
import com.bootcamp.bc_forum.entity.AddressEntity;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.entity.CompanyEntity;
import com.bootcamp.bc_forum.entity.GeoEntity;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.UserDTO.CommentDTO;
import lombok.Getter;

@Getter
@Component
public class Mapper {

  public UserEntity map(User user){
    return UserEntity.builder()
    .id(user.getId())
    .name(user.getName())
    .username(user.getUsername())
    .email(user.getEmail())
    .phone(user.getPhone())
    .website(user.getWebsite())
    .build();
  }

  public PostEntity map(Post post){
    return PostEntity.builder()
    .id(post.getId())
    .body(post.getBody())
    .title(post.getTitle())
    .body(post.getBody())
    .build();
  }

  public CommentEntity map(Comment comment){
    return CommentEntity.builder()
    .id(comment.getId())
    .name(comment.getName())
    .email(comment.getEmail())
    .body(comment.getBody())
    .build();
  }

  public AddressEntity mapToAddressEntity(User user){
    return AddressEntity.builder()
    .street(user.getAddress().getStreet())
    .suite(user.getAddress().getSuite())
    .city(user.getAddress().getCity())
    .zipcode(user.getAddress().getZipcode())
    .build();
  }
  
  public CompanyEntity mapToCompanyEntity(User user) {
    return CompanyEntity.builder()
        .name(user.getCompany().getName())
        .catchPhrase(user.getCompany().getCatchPhrase())
        .bs(user.getCompany().getBs())
        .build();
  }

  public GeoEntity mapToGeoEntity(User user) {
    return GeoEntity.builder()
        .lat(user.getAddress().getGeo().getLat())
        .lng(user.getAddress().getGeo().getLng())
        .build();
  }

  public UserDTO map(UserEntity userEntity){

  }

  public PostDTO map(PostEntity postEntity){
    
  }

  public CommentDTO map(CommentEntity commentEntity){
    
  }

}
