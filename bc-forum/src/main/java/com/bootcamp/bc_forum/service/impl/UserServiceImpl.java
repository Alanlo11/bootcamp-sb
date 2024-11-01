package com.bootcamp.bc_forum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.repository.UserRepository;
import com.bootcamp.bc_forum.service.UserService;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userentities) {
    return userRepository.saveAll(userentities);
  }

  @Override
  public List<UserEntity> getAll() {
    return userRepository.findAll();
  }
  
}