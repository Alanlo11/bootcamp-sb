package com.bootcamp.demo_restapi2.model;

import lombok.Getter;

@Getter
public class PostDTO {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
