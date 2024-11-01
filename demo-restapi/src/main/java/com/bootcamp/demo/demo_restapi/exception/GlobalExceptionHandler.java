package com.bootcamp.demo.demo_restapi.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.demo_restapi.infra.GeneralResponse;
import com.bootcamp.demo.demo_restapi.infra.SysCode;

// 1. -> Method A -> Method B -> Method C -> return object to B -> return object to A
// 2. -> Method A -> Method B -> Method C -> throw exception -> B handle exception ...

@RestControllerAdvice // bean ExceptionHandler 用呢個annotation
public class GlobalExceptionHandler {

  // will throw error if you catching same exception
  // try to catch
  @ExceptionHandler(BusinessException.class)
  public ErrorResponse bussinessExceptionHandler(BusinessException e) {
    return ErrorResponse.builder()
        .code(0)
        .message(e.getMessage()) //
        .build();
  }

  @ExceptionHandler(UserNotExistException.class)
  public ErrorResponse userNotExistException(UserNotExistException e){
    return ErrorResponse.builder()
    .code(e.getCode())
    .message(e.getMessage())
    .build();
  }

  @ExceptionHandler(Exception.class)
  public GeneralResponse<Object> exceptionHandler(Exception e) {
    return GeneralResponse.<Object>builder() //
        .status(SysCode.FAIL) //
        .build();
  }

}
