package com.bootcamp.demo_restapi2.util;

public class BusinessException extends RuntimeException{
  private int code;

  public BusinessException(ErrorCode errorCode) {
    this(errorCode.getCode(), errorCode.getMessage());
  }

  private BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  public int code() {
    return this.code;
  }
}
