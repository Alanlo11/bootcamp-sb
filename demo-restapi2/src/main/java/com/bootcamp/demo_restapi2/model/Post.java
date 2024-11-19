package com.bootcamp.demo_restapi2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
  private Long id;
  private String title;
  private String body;
}
