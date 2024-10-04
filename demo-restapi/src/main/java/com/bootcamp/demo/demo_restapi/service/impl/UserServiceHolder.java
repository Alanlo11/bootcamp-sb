package com.bootcamp.demo.demo_restapi.service.impl;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_restapi.bootcamp.Scheme;
import com.bootcamp.demo.demo_restapi.bootcamp.UrlManager;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.User;
import com.bootcamp.demo.demo_restapi.model.mapper.Mapper;
import com.bootcamp.demo.demo_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_restapi.service.UserService;

@Service
public class UserServiceHolder implements UserService {
  // ! @Value: Before @Service bean created, Spring finds "api.url" value from
  // application.yml

  // Field Injection
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mapper mapper;

  // Constructor Injection
  // @Autowired
  // public UserServiceHolder(@Value("${api.url.domain}") String domain, 
  //     @Value("${api.url.endpoint}") String endpoint, RestTemplate restTemplate) {
  //   this.domain = domain;
  //   this.endpoint = endpoint;
  //   this.restTemplate = restTemplate;
  // }

  @Override
  public User[] getUsers() {
    // call API from "jsonplaceholder.typicode.com/users"
    // we receive User Array

    // getForObject(): call API + serialize result and convert to User[]
    String url = UrlManager.builder()
        .scheme(Scheme.HTTPS)
        .domain(this.domain)
        .endpoint(this.endpoint)
        .build()
        .toString();

    System.out.println("url=" + url); // debug

    User[] users = this.restTemplate.getForObject(url, User[].class);

    if(userRepository.findAll().size() == 0){
    Arrays.asList(users).stream()
    .forEach(user -> {
      UserEntity userEntity = mapper.map(user);
      userRepository.save(userEntity);
    });
  } else {
    System.out.println("Alredy have data");
  }

    // System.out.println("users=" + Arrays.toString(users));
    return users;
  }
}