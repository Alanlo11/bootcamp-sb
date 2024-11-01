package com.bootcamp.demo.demo_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GovUserDto {
  private String name;
  private String email;
}