package com.bootcamp.demo.demo_restapi.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_restapi.infra.Scheme;
import com.bootcamp.demo.demo_restapi.infra.UrlManager;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.exception.BusinessException;
import com.bootcamp.demo.demo_restapi.exception.ErrorCode;
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
  // @Value("${api.url.endpoint}") String endpoint, RestTemplate restTemplate) {
  // this.domain = domain;
  // this.endpoint = endpoint;
  // this.restTemplate = restTemplate;
  // }

  @Override
  public User[] getUsers() {
    // call API from "jsonplaceholder.typicode.com/users"
    // we receive User Array

    // getForObject(): call API + serialize result and convert to User[]
    String url = UrlManager.builder().scheme(Scheme.HTTPS).domain(this.domain)
        .endpoint(this.endpoint).build().toString();

    System.out.println("url=" + url); // debug

    User[] users = this.restTemplate.getForObject(url, User[].class); // 左邊係in，右邊係output.Class

    if (userRepository.findAll().size() == 0) {
      Arrays.asList(users).stream().forEach(user -> {
        userRepository.save(mapper.map(user));
      });
    } else {
      System.out.println("Alredy have data");
    }

    // System.out.println("users=" + Arrays.toString(users));
    return users;
  }

  @Override
  public User getUsers(String id) {
    User[] temp = getUsers();
    for (User user : temp) {
      if (Integer.valueOf(id).equals(user.getId())) {
        System.out.println(user);
        return user;
      }
    }
    return new User();
  }

  @Override
  public UserEntity createNewUser(String name, String email, String phone) {
    return userRepository.save(UserEntity.builder()//
        .name(name)//
        .email(email)//
        .phone(phone)//
        .build());
  }

  @Override
  public Optional<UserEntity> getUsersFromDB(Long id) {
    return userRepository.findById(id);
  }
  
  // Controller -> Service.deleteById()
  @Override
  public void deleteById(Long id) {
    if (!this.userRepository.existsById(id))
      throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND); // exception object
    this.userRepository.deleteById(id); // delete from Users wgere id = 10000;
  }
}
