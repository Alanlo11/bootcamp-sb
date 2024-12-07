package com.bootcamp.demo_sb_yahoo_finance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockSymbolDTO {
  private Long id;
  private String symbol;
}
