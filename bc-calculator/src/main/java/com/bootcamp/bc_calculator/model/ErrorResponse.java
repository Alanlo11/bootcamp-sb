package com.bootcamp.bc_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class ErrorResponse {
  private String code;
  private String message;
}