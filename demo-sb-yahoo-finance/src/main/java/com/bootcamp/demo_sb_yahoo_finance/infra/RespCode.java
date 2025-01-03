package com.bootcamp.demo_sb_yahoo_finance.infra;

public enum RespCode {
  OK("000000", "Success"),
  FAIL("900000", "Fail"),
  EXCEPTION("999999", "Unhandled Exception"),
  ;

  private String code;
  private String message;

  private RespCode(String code, String message){
    this.code = code;
    this.message = message;
  }

  public String getCode(){
    return this.code;
  }

  public String getMessage(){
    return this.message;
  }

}