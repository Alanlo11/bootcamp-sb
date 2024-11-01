package com.bootcamp.bc_forum.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UrlManager {

  @Value("${api.url.domain}")
  private String domain;

  public String getUrl(String endpoint){
    return UriComponentsBuilder.newInstance()
    .scheme(Scheme.HTTPS.name())
    .host(domain)
    .path(endpoint)
    .toUriString();
  }

}