package com.bootcamp.demo_thymeleaf.dto;

import java.time.LocalDateTime;
import com.bootcamp.demo_thymeleaf.util.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoinDto {
  private String id;
  private String symbol; // btc eth usdt (upper case)
  private String name;
  private String image;

  @JsonProperty("current_price")
  private Double currentPrice;

  @JsonProperty("market_cap")
  private Long marketCap;

  @JsonProperty("last_updated")
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime lastUpdated; // UTC -> UTC+8

  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercent24h;
}
