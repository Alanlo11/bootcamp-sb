package com.bootcamp.demo_sb_yahoo_finance.exception;

public class ErrorException extends RuntimeException{
  private String message;
  private int code;

  public ErrorException(ErrorCode errorCode){
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }

  public ErrorException(Error error, String message){
    super(message);
    this.code = error.getCode();
  }

  public int getCode(){
    return this.code;
  }
}
