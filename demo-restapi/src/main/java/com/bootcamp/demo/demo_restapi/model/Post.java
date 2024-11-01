package com.bootcamp.demo.demo_restapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Post {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
