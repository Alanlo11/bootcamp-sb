package com.bootcamp.bc_calculator.exception;

import lombok.Getter;

@Getter
public class CannotdivideZeroException extends IllegalArgumentException{
  private String code;
  private String message;
  
  public CannotdivideZeroException(ErrorCode errorCode){
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }
}
