package com.bootcamp.demo_sb_yahoo_finance.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class UrlManager {
  private Scheme scheme;
  private String domain;
  private String endpoint;

  private UrlManager(Builder builder){
    this.scheme = builder.scheme == null ? Scheme.HTTPS : builder.scheme;
    this.domain = builder.domain;
    this.endpoint = builder.endpoint;
  }

  public static UrlManager.Builder builder() {
    return new Builder();
  }

  @Override
  public String toString(){
    return this.scheme.getValue()
    .concat(this.domain)
    .concat(this.endpoint);
  }

  public String toUriString() {
    return UriComponentsBuilder.newInstance()
      .scheme(this.scheme.name().toLowerCase())
      .host(this.domain)
      .path(this.endpoint)
      .toUriString();
  }

  public static class Builder {
    private Scheme scheme;
    private String domain;
    private String endpoint;

    public Builder scheme(Scheme scheme) {
      this.scheme = scheme;
      return this;
    }

    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }

    public Builder endpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public UrlManager build() {
      return new UrlManager(this);
    }
  }
}
