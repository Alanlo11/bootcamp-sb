package com.bootcamp.bc_calculator.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.bootcamp.bc_calculator.controller.Operation;
import com.bootcamp.bc_calculator.exception.ErrorCode;
import com.bootcamp.bc_calculator.exception.InvalidInputException;
import com.bootcamp.bc_calculator.model.APIResponse;
import com.bootcamp.bc_calculator.service.CalculatorService;

@Service
public class CalculatorServiceHolder implements CalculatorService{
  @Override
  public APIResponse calculator(BigDecimal x, BigDecimal y, String operation) {
    Operation op = this.map(operation);
    
    return APIResponse.builder()
    .x(String.valueOf(x))
    .y(String.valueOf(y))
    .operation(op.getOperation())
    .result(op.calculate(x, y))
    .build();
  }

  private Operation map(String operation){
    for (Operation op : Operation.values()){ // // Enum.values() return Enum[]
      if(op.getOperation().equals(operation)){
        return op;
      }
    }
    throw new InvalidInputException(ErrorCode.INVALIDINPUT);
  }
  
}
