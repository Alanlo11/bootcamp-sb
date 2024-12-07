package com.bootcamp.demo_sb_yahoo_finance.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ErrorResponse {
  private int code;
  private String message;
}
