package com.bootcamp.demo.demo_restapi.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_restapi.entity.CompanyEntity;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.Post;
import com.bootcamp.demo.demo_restapi.model.mapper.Mapper;
import com.bootcamp.demo.demo_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_restapi.service.PostService;
import com.bootcamp.demo.demo_restapi.service.UserService;

@Component
public class SavaDataRunner {
  // implements CommandLineRunner
  // @Autowired
  // private UserRepository userRepository;

  // @Autowired
  // private UserService userService;

  // @Autowired
  // private PostService postService;

  // @Autowired
  // private Mapper mapper;

  // @Override
  // public void run(String... args) throws Exception {

  //   // get Users from website
  //   List<User> users = Arrays.asList(this.userService.getUsersFromWebSite());
  //   // get Posts from website
  //   List<Post> posts = Arrays.asList(this.postService.getPosts());

  //   // Construct List<UserEntity>
  //   List<UserEntity> userEntities = users.stream().map(u -> {
  //     UserEntity userEntity = this.mapper.map(u);

  //     List<PostEntity> postEntities = posts.stream()
  //     .filter(p -> p.getUserId().equals(u.getId()))
  //     .map(p -> {
  //       PostEntity postEntity = this.mapper.map(p);
  //       postEntity.setUser(userEntity);
  //       return postEntity;
  //     })
  //     .collect(Collectors.toList());

  //     CompanyEntity companyEntity = this.mapper.map(u.getCompany());
  //     companyEntity.setCompany(companyEntity);
  //     return userEntity;
  //   }).collect(Coll)
  //   // save all in the same time
  //   userRepository.saveAll(userEntities);
  //   });
  // }

}
