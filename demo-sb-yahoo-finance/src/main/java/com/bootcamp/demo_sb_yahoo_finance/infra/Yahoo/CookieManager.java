package com.bootcamp.demo_sb_yahoo_finance.infra.Yahoo;


import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo_sb_yahoo_finance.infra.Scheme;

public class CookieManager {

  private RestTemplate restTemplate;

  public CookieManager(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String getCookie() {
    try {
      String cookieUrl = UriComponentsBuilder.newInstance()//
          .scheme(Scheme.HTTPS.name().toLowerCase())//
          .host(YahooFinance.DOMAINE)//
          .toUriString();
      ResponseEntity<String> entity =
          restTemplate.getForEntity(cookieUrl, String.class);
      List<String> cookies = entity.getHeaders().get("Set-Cookie");

      return cookies != null ? cookies.get(0).split(";")[0] : null;
    } catch (RestClientException e) {
      if (e instanceof HttpStatusCodeException) {
        HttpHeaders headers =
            ((HttpStatusCodeException) e).getResponseHeaders();
        if (headers != null) {
          List<String> cookies = headers.get("Set-Cookie");
          return cookies != null ? cookies.get(0).split(";")[0] : null;
        }
      }
    }
    return null;
  }
}
