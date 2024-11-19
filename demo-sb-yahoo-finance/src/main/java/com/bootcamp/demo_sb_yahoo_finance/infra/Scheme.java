package com.bootcamp.demo_sb_yahoo_finance.infra;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTP("http://"),
  HTTPS("https://"),
  ;

  private String value;

  private Scheme(String value){
    this.value = value;
  }
}
