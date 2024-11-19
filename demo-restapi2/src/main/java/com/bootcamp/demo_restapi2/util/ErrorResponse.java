package com.bootcamp.demo_restapi2.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
  private int code;
  private String message;
}
