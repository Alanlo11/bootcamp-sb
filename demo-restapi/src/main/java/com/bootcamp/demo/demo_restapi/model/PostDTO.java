package com.bootcamp.demo.demo_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}