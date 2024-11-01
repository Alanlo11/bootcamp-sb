package com.bootcamp.bc_forum.model;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.bootcamp.bc_forum.entity.AddressEntity;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.entity.CompanyEntity;
import com.bootcamp.bc_forum.entity.GeoEntity;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.UserDTO.AddressDTO;
import com.bootcamp.bc_forum.model.UserDTO.CompanyDTO;
import com.bootcamp.bc_forum.model.UserDTO.GeoDTO;
import com.bootcamp.bc_forum.model.UserDTO.PostDTO;

@Component
public class Mapper {

  public UserEntity map(User user) {
    return UserEntity.builder()//
        .name(user.getName())//
        .username(user.getUsername())//
        .phone(user.getPhone())//
        .email(user.getEmail())//
        .website(user.getWebsite())//
        .build();
  }

  public AddressEntity mapToAddressEntity(User user) {
    return AddressEntity.builder()//
        .street(user.getAddress().getStreet())//
        .suite(user.getAddress().getSuite())//
        .city(user.getAddress().getCity())//
        .zipcode(user.getAddress().getZipcode())//
        .build();

  }

  public CompanyEntity mapToCompanyEntity(User user) {
    return CompanyEntity.builder()//
        .name(user.getCompany().getName())//
        .catchPhrase(user.getCompany().getCatchPhrase())//
        .bs(user.getCompany().getBs())//
        .build();

  }

  public GeoEntity mapToGeoEntity(User user) {
    return GeoEntity.builder()//
        .lat(user.getAddress().getGeo().getLat())//
        .lng(user.getAddress().getGeo().getLng())//
        .build();

  }

  public PostEntity map(Post post) {
    return PostEntity.builder()//
        .title(post.getTitle())//
        .body(post.getBody())//
        .build();

  }

  public CommentEntity map(Comment comment) {
    return CommentEntity.builder()//
        .name(comment.getName())//
        .email(comment.getEmail())//
        .body(comment.getBody())//
        .build();
  }

  public UserDTO map(UserEntity userEntity) {

    GeoDTO geoDTO = GeoDTO.builder()//
        .lng(userEntity.getAddressEntity().getGeoEntity().getLng())//
        .lat(userEntity.getAddressEntity().getGeoEntity().getLng()).build();

    AddressDTO addressDTO = AddressDTO.builder()//
        .street(userEntity.getAddressEntity().getStreet())//
        .suite(userEntity.getAddressEntity().getSuite())//
        .city(userEntity.getAddressEntity().getCity())//
        .zipcode(userEntity.getAddressEntity().getZipcode())//
        .geoDTO(geoDTO)//
        .build();

    CompanyDTO companyDTO = CompanyDTO.builder()//
        .name(userEntity.getCompanyEntity().getName())//
        .catchPhrase(userEntity.getCompanyEntity().getCatchPhrase())//
        .bs(userEntity.getCompanyEntity().getBs())//
        .build();

    List<CommentDTO> commentDTOs = userEntity.getPosts().stream()//
        .map(post -> {
          CommentDTO commentDTO = post.getComments().stream()//
              .map(commentEntity -> this.map(commentEntity))//
              .findFirst()//
              .get();
          return commentDTO;
        })//
        .collect(Collectors.toList());

    List<PostDTO> postDTOs = userEntity.getPosts().stream()//
        .map(postEntity -> {
          PostDTO postDTO = this.map(postEntity);
          postDTO.setComments(commentDTOs);
          return postDTO;
        })//
        .collect(Collectors.toList());

    return UserDTO.builder()//
        .id(userEntity.getId())//
        .name(userEntity.getName())//
        .username(userEntity.getUsername())//
        .email(userEntity.getEmail())//
        .phone(userEntity.getPhone())//
        .website(userEntity.getWebsite())//
        .company(companyDTO)//
        .address(addressDTO)//
        .posts(postDTOs)//
        .build();
  }

  public PostDTO map(PostEntity postEntity) {

    // without using Builder pattern
    // PostDTO postDTO = new PostDTO();
    // postDTO.setBody(postEntity.getBody());
    // postDTO.setTitle(postEntity.getTitle());
    // return postDTO;

    return PostDTO.builder()//
        .id(postEntity.getId())//
        .body(postEntity.getBody())//
        .title(postEntity.getTitle())//
        .build();
  }

  // Wrong presentation
  // we separate 2 CommentDTO class first , but it is stupid
  // Finally : create one CommentDTO
  // public CommentDTO map(CommentEntity commentEntity){

  // }

  // public com.bootcamp.bc_forum.model.UserDTO.CommentDTO mapToDTO(CommentEntity commentEntity){

  // }
  public CommentDTO map(CommentEntity commentEntity) {
    return CommentDTO.builder()//
        .id(commentEntity.getId())
        .postId(commentEntity.getPosts().getId())//
        .name(commentEntity.getName())//
        .body(commentEntity.getBody())//
        .email(commentEntity.getEmail()).build();
  }
}