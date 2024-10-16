package com.bootcamp.demo.demo_restapi.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  USER_ID_NOT_FOUND(1, "User ID Not Found"), //
  OK(100, "Response OK."), //
  CANNOT_LOGIN(200, "Cannot Login"), //
  API(500, "Third part API error"),//
  BUSSINESS_EXCEPTION(600,"Businness Exception"),//
  ;

  private int code;
  private String message;

  private ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
