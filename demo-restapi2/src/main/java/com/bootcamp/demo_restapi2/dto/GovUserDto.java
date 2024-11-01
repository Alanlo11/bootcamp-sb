package com.bootcamp.demo_restapi2.dto;

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