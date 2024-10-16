package com.bootcamp.demo.demo_restapi.infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UrlManager {
  private Scheme scheme;
  private String domain;
  private String endpoint;

  @Override
  public String toString() {
    return this.scheme.getUrlPrefix() //
        .concat(this.domain) //
        .concat(this.endpoint);
  }
}