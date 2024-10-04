package com.bootcamp.demo.demo_restapi.bootcamp;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTP("http://"),
  HTTPS("https://"),
  ;

  private String urlPrefix;

  private Scheme(String urlPrefix) {
    this.urlPrefix = urlPrefix;
  }
}