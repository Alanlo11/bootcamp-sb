package com.bootcamp.bc_forum.config;

public enum Scheme {
  HTTP("http://"),
  HTTPS("https://"),
  ;

private String scheme;

  private Scheme(String scheme){
    this.scheme = scheme;
  }

}