package com.bootcamp.demo_user.infra;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UrlManager {
  private Scheme scheme;
  private String domain;
  private String endpoint;

  @Override
  public String toString(){
    return this.scheme.getValue()
    .concat(this.domain)
    .concat(this.endpoint);
  }
}
