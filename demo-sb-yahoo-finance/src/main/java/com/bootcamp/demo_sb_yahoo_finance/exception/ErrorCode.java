package com.bootcamp.demo_sb_yahoo_finance.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  RUNTIME_ERROR(666, "Runtime Error"), //
  UNKNOWN_ERROR(777, "Unknown Error"), //
  Entity_NOT_FOUND(1, "Entity not found."),
  INVALID_INPUT(8, "Invalid Input."),
  SYSDATE_NOT_READY(9,"System Date not ready!");

  private int code;
  private String message;

  private ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
