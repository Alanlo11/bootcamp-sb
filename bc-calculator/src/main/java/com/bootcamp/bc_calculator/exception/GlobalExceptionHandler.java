package com.bootcamp.bc_calculator.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.bc_calculator.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CannotdivideZeroException.class)
  public ErrorResponse cannotDivideZero() {
    return ErrorResponse.builder()
        .code(ErrorCode.CANNOTDIVIDEZERO.getCode())
        .message(ErrorCode.CANNOTDIVIDEZERO.getMessage())
        .build();
  }

  @ExceptionHandler(InvalidInputException.class)
  public ErrorResponse invalidInput() {
    return ErrorResponse.builder()
        .code(ErrorCode.INVALIDINPUT.getCode())
        .message(ErrorCode.INVALIDINPUT.getMessage())
        .build();
  }

  @ExceptionHandler(RuntimeException.class)
  public ErrorResponse runtimeException() {
    return ErrorResponse.builder()//
    .code(ErrorCode.INVALIDINPUT.getCode())
    .message(ErrorCode.INVALIDINPUT.getMessage())
    .build();
  }

  @ExceptionHandler(ArithmeticException.class)
  public ErrorResponse aithmeticException() {
    return ErrorResponse.builder()//
    .code(ErrorCode.CANNOTDIVIDEZERO.getCode())
    .message(ErrorCode.CANNOTDIVIDEZERO.getMessage())
    .build();
  }

  @ExceptionHandler(Exception.class)
  public ErrorResponse catchException() {
    return ErrorResponse.builder()
    .code(ErrorCode.INVALIDINPUT.getCode())
    .message(ErrorCode.INVALIDINPUT.getMessage())
    .build();
  }

}
