package com.bootcamp.bc_calculator.exception;

import lombok.Getter;

@Getter
public class InvalidInputException extends IllegalArgumentException{
  private String code;
  private String message;


  public InvalidInputException(ErrorCode errorCode){
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }
}
