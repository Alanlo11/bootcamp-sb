package com.bootcamp.demo.demo_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserDTO {
  private String name;
  private String email;
  private String website;
}
