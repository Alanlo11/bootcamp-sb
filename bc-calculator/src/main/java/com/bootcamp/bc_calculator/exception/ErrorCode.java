package com.bootcamp.bc_calculator.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  CANNOTDIVIDEZERO("000000","Cannot Divide Zero"),
  INVALIDINPUT("500000", "Invald Input"),
  ;
  private String code;
  private String message;

  private ErrorCode(String code, String message){
    this.code = code;
    this.message = message;
  }

}