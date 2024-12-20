package com.bootcamp.demo_sb_yahoo_finance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({RuntimeException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND) // 404
  public ErrorResponse handleRuntimeException() {
    return ErrorResponse.builder()//
        .code(ErrorCode.RUNTIME_ERROR.getCode())//
        .message(ErrorCode.RUNTIME_ERROR.getMessage())//
        .build();
  }

}
