package com.bootcamp.demo_user.service.impl;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_user.entity.UserEntity;
import com.bootcamp.demo_user.infra.Scheme;
import com.bootcamp.demo_user.infra.UrlManager;
import com.bootcamp.demo_user.model.User;
import com.bootcamp.demo_user.model.mapper.Mapper;
import com.bootcamp.demo_user.repository.UserRepository;
import com.bootcamp.demo_user.service.UserService;

@Service
public class UserServiceHolder implements UserService{
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint}")
  private String endpoint;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private Mapper mapper;

  @Override
  public User[] getUsers(){
    String url = UrlManager.builder()
    .scheme(Scheme.HTTPS)
    .domain(domain)
    .endpoint(endpoint)
    .build()
    .toString();

    User[] users = restTemplate.getForObject(url, User[].class);

    if(userRepository.findAll().size() == 0){
      Arrays.asList(users).stream()
      .forEach(user -> {
        UserEntity userEntity = mapper.toUserEntity(user);
        userRepository.save(userEntity);
      });
    } else {
      System.out.println("User have DATA");
    }

    return users;
  }

}