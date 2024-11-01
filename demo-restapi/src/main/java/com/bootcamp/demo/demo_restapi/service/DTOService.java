package com.bootcamp.demo.demo_restapi.service;

import com.bootcamp.demo.demo_restapi.model.UserPostDTO;

public interface DTOService {
  UserPostDTO getUserPostDTOs(String userID , String postID);
}
