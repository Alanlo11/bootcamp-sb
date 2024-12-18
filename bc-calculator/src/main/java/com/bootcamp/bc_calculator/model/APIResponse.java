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
@NoArgsConstructor
@ToString
@Setter
public class APIResponse {
  private String x;
  private String y;
  private String operation;
  private String result;

}