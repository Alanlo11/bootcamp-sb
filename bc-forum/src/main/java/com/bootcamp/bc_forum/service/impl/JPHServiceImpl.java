package com.bootcamp.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_forum.config.UrlManager;
import com.bootcamp.bc_forum.entity.AddressEntity;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.entity.CompanyEntity;
import com.bootcamp.bc_forum.entity.GeoEntity;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.Comment;
import com.bootcamp.bc_forum.model.Mapper;
import com.bootcamp.bc_forum.model.Post;
import com.bootcamp.bc_forum.model.User;
import com.bootcamp.bc_forum.service.JPHService;
import com.bootcamp.bc_forum.service.UserService;

@Service
public class JPHServiceImpl implements JPHService{

  @Autowired
  private UrlManager urlManager;

  @Value("${api.url.comments}")
  private String commentsEndpoint;

  @Value("${api.url.posts}")
  private String postsEndpoint;

  @Value("${api.url.users}")
  private String usersEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserService userService;

  @Autowired
  private Mapper mapper;

  @Override
  public List<Comment> getComments() {
    String url = urlManager.getUrl(commentsEndpoint).toString();
    return Arrays.asList(restTemplate.getForObject(url, Comment[].class));
  }

  @Override
  public List<Post> getPosts() {
    String url = urlManager.getUrl(postsEndpoint).toString();
    return Arrays.asList(restTemplate.getForObject(url, Post[].class));
  }

  @Override
  public List<User> getUsers(){
    String url = urlManager.getUrl(usersEndpoint).toString();
    return Arrays.asList(restTemplate.getForObject(url, User[].class));
  }

  @Override
  public String saveAll(){
    List<User> users = this.getUsers();
    List<Post> postPlaceHolders = this.getPosts();
    List<Comment> commentPlaceHolders = this.getComments();
    
    // Convert and construct UserEntity
    List<UserEntity> userEntities = users.stream().map(uDto -> {
      UserEntity userEntity = this.mapper.map(uDto);

      AddressEntity addressEntity = this.mapper.mapToAddressEntity(uDto);

      GeoEntity geoEntity = this.mapper.mapToGeoEntity(uDto);
      geoEntity.setAddress(addressEntity);

      addressEntity.setGeoEntity(geoEntity);
      addressEntity.setUser(userEntity);

      CompanyEntity companyEntity = this.mapper.mapToCompanyEntity(uDto);
      companyEntity.setUser(userEntity);

      List<PostEntity> postEntities = postPlaceHolders.stream() //
          .filter(pDto -> pDto.getUserId().equals(uDto.getId())) //
          .map(pDto -> {
            PostEntity postEntity = this.mapper.map(pDto);

            List<CommentEntity> commentEntities = commentPlaceHolders.stream() //
                .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
                .map(cDto -> {
                  CommentEntity commentEntity = this.mapper.map(cDto);
                  commentEntity.setPosts(postEntity);
                  return commentEntity;
                }).collect(Collectors.toList());

            postEntity.setComments(commentEntities);
            postEntity.setUser(userEntity);
            return postEntity;
          }) //
          .collect(Collectors.toList());

      userEntity.setAddressEntity(addressEntity);
      userEntity.setCompanyEntity(companyEntity);
      userEntity.setPosts(postEntities);
      return userEntity;
    }).collect(Collectors.toList());

      // Save all data to all Users, Posts, Comments, Addresses, Companies, Geos
      userService.saveAll(userEntities);

      return "Save All Already!";
    // for-loop X 3
    // for (UserPlaceHolder user : userPlaceHolders) {
    //   for (PostPlaceHolder post : postPlaceHolders) {
    //     for (CommentPlaceHolder comment : commentPlaceHolders) {

    //     }
    //   }
    // }
  }
  
}
