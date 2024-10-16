package com.bootcamp.demo.demo_restapi.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class ApiUtil {
  
  @Value("${api.url.domain}") // before server start, base 
  String domain;

  // @Value("${api.endpoint.user}")
  // String  userEndpoint;

  public String getUrl(Scheme scheme , String domain, String endpoint){
    String url = UriComponentsBuilder.newInstance()
      .scheme(scheme.name())
      .host(domain)
      .path(endpoint)
      .toUriString(); // 組合api
      System.out.println("URL" + url);
      return UriComponentsBuilder.newInstance()
      .scheme(scheme.name())
      .host(domain)
      .path(endpoint)
      .toUriString();
  }
}
