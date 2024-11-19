package com.bootcamp.demo_restapi2.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_restapi2.entity.CompanyEntity;
import com.bootcamp.demo_restapi2.entity.PostEntity;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.mapper.JPHMapper;
import com.bootcamp.demo_restapi2.model.PostDTO;
import com.bootcamp.demo_restapi2.model.UserDTO;
import com.bootcamp.demo_restapi2.repository.UserRepository;
import com.bootcamp.demo_restapi2.service.PostService;
import com.bootcamp.demo_restapi2.service.UserService;

@Component
public class SaveDataRunner implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private JPHMapper jphMapper;

  @Override
  public void run(String... args) throws Exception {
    // get Users from website
    List<UserDTO> users = this.userService.getUsersFromWebsite();
    // get Posts from website
    List<PostDTO> posts = this.postService.getPosts();

    // construct List<UserEntity>
    // stream + filter
    List<UserEntity> userEntities = users.stream().map(u -> {
      UserEntity userEntity = this.jphMapper.map(u);

      List<PostEntity> postEntities = posts.stream() //
          .filter(p -> p.getUserId().equals(u.getId())) //
          .map(p -> {
            PostEntity postEntity = this.jphMapper.map(p);
            postEntity.setUser(userEntity);
            return postEntity;
          }) //
          .collect(Collectors.toList());

      CompanyEntity companyEntity = this.jphMapper.map(u.getCompany());
      companyEntity.setUser(userEntity);

      userEntity.setPosts(postEntities);
      userEntity.setCompany(companyEntity);
      return userEntity;
    }).collect(Collectors.toList());

    // Save All users, companies and posts at the same time.
    userRepository.saveAll(userEntities);
  }
}