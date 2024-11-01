package com.bootcamp.bc_calculator.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.bootcamp.bc_calculator.exception.CannotdivideZeroException;
import com.bootcamp.bc_calculator.exception.ErrorCode;
import com.bootcamp.bc_calculator.exception.InvalidInputException;
import lombok.Getter;

@Getter
public enum Operation {
  ADD("add"),
  SUBTRACT("sub"),
  MULTIPLY("mul"),
  DIVIDE("div"),
  ;

  private String operation;

  private Operation(String operation){
    this.operation = operation;
  }

  public String calculate(BigDecimal x, BigDecimal y){
    return switch (this) {
      case ADD -> x.add(y).setScale(5).toString();
      case SUBTRACT -> x.subtract(y).setScale(5).toString();
      case MULTIPLY -> x.multiply(y).setScale(5).toString();
      // DividerZeroException
      case DIVIDE ->  {
        if (BigDecimal.ZERO.equals(y)) {
          throw new CannotdivideZeroException(ErrorCode.CANNOTDIVIDEZERO);
        }
        yield x.divide(y,5,RoundingMode.HALF_UP).toString();
      }
      default -> 
        throw new InvalidInputException(ErrorCode.INVALIDINPUT);
    };
  }

}