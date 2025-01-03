package com.bootcamp.demo_sb_yahoo_finance.model.line;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class Base extends PriceType{
  private double close;
}
