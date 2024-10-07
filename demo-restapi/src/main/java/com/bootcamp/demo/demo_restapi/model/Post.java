package com.bootcamp.demo.demo_restapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Post {
  private Integer userId;
  private Integer id;
  private String title;
  private String body;
}
