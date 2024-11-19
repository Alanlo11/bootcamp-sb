package com.bootcamp.demo_restapi2.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_restapi2.entity.UserEntity;
import com.bootcamp.demo_restapi2.mapper.JPHMapper;
import com.bootcamp.demo_restapi2.model.UserDTO;
import com.bootcamp.demo_restapi2.repository.UserRepository;
import com.bootcamp.demo_restapi2.service.UserService;
import com.bootcamp.demo_restapi2.util.BusinessException;
import com.bootcamp.demo_restapi2.util.ErrorCode;
import com.bootcamp.demo_restapi2.util.UrlManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceHolder implements UserService{
  // ! @Value: Before @Service bean created, Spring finds "api.url" value from
  // application.yml

  // Field Injection
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint.users}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private JPHMapper jphMapper;

  // Constructor Injection
  // @Autowired
  // public UserServiceHolder(@Value("${api.url.domain}") String domain,
  // @Value("${api.url.endpoint}") String endpoint, RestTemplate restTemplate) {
  // this.domain = domain;
  // this.endpoint = endpoint;
  // this.restTemplate = restTemplate;
  // }
  @Override
  public List<UserDTO> getUsersFromWebsite() {
    String url = UrlManager.builder() //
        // .scheme(Scheme.HTTPS) //
        .domain(this.domain) //
        .endpoint(this.endpoint) //
        .build() //
        .toUriString();

    System.out.println("url=" + url); // debug
    return Arrays.asList(this.restTemplate.getForObject(url, UserDTO[].class));
  }
  @Override
  public UserDTO[] getUsers() {
    // call API from "jsonplaceholder.typicode.com/users"
    // we receive User Array
    
    // getForObject(): call API + serialize result and convert to User[]
    String url = UrlManager.builder() //
        // .scheme(Scheme.HTTPS) //
        .domain(this.domain) //
        .endpoint(this.endpoint) //
        .build() //
        .toString();

    System.out.println("url=" + url); // debug
    UserDTO[] users = this.restTemplate.getForObject(url, UserDTO[].class);

    // Save the users into Database
    Arrays.asList(users).stream().forEach(user -> {
      userRepository.save(this.jphMapper.map(user)); //
    });

    // System.out.println("users=" + Arrays.toString(users));
    return users;
  }

  @Override
  public Optional<UserEntity> getUserFromDB(Long id) {
    return this.userRepository.findById(id);
  }

  // Controller -> Service.deleteById
  @Override
  public void deleteById(Long id) {
    if (!this.userRepository.existsById(id))
      throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND); // exception
                                                                // object
    this.userRepository.deleteById(id);
  }

  @Override
  public UserEntity getUserByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }

  @Override
  public List<UserDTO> getUserFromRedis() throws JsonProcessingException {
    String key = this.redisTemplate.opsForValue().get("user");
    if(key == null){
      List<UserDTO> users = this.userRepository.findAll().stream()
      .map(u -> this.jphMapper.map(u))
      .collect(Collectors.toList());
      String jsonToWrite = this.objectMapper.writeValueAsString(users);
      this.redisTemplate.opsForValue().set("user", jsonToWrite);
      return users;
    }
    return Arrays.asList(this.objectMapper.readValue(key, UserDTO[].class));
  }

  
}