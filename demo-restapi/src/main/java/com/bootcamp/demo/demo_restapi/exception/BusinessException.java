package com.bootcamp.demo.demo_restapi.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
  private int code;

  public BusinessException(ErrorCode errorcode){
    this(errorcode.getCode(), errorcode.getMessage());
  }

  private BusinessException(int code, String message){
    super(message);
    this.code = code;
  }

}