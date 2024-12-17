package com.bootcamp.demo_sb_yahoo_finance.model.line;

import lombok.Getter;

@Getter
public enum TranType {
  FIVE_MINUTES("5M"), //
  DAILY("D"), //
  WEEKLY("W"), //
  MONTHLY("M"),//
  ;

  private String type;

  private TranType(String type) {
    this.type = type;
  }
  
}
