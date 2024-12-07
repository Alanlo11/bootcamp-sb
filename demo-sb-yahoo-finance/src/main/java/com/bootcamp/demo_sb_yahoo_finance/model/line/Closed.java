package com.bootcamp.demo_sb_yahoo_finance.model.line;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Closed implements Price {
  private Double close;
}
