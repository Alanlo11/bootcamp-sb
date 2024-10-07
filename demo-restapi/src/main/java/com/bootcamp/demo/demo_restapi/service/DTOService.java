package com.bootcamp.demo.demo_restapi.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_restapi.model.UserPostDTO;

@Service
public interface DTOService {
  UserPostDTO getUserPostDTOs(String userID , String postID);
}
