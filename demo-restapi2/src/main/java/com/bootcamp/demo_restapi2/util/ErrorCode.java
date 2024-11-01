package com.bootcamp.demo_restapi2.util;

public enum ErrorCode {
  USER_ID_NOT_FOUND(1, "User ID Not Found."), //
  ;

  private int code;
  private String message;

  private ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
