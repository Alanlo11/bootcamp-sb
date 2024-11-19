package com.bootcamp.demo_restapi2.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // bean
public class GlobalExceptionHandler {
  // try to catch BusinessException
  @ExceptionHandler(BusinessException.class)
  public ErrorResponse bussinessExceptionHandler(BusinessException e) {
    return ErrorResponse.builder()
        .code(0)
        .message(e.getMessage()) //
        .build();
  }

  @ExceptionHandler(Exception.class)
  public GeneralResponse<Object> exceptionHandler(Exception e) {
    return GeneralResponse.<Object>builder() //
        .status(SysCode.FAIL) //
        .build();
  }
}
