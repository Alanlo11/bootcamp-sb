package com.bootcamp.demo_sb_yahoo_finance.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tstocks_price")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// @JsonPropertyOrder({"stock_id", "symbol", "regularMarketTime",
//     "regularMarketPrice", //
//     "regularMarketChangePercent", "bid", "bidSize", "ask", "askSize", "type",
//     "apiDateTime", "marketUnixTime", "stock"}) // 顯示順序

public class StockPrice implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String symbol;
  private String tranType;
  private LocalDateTime tranDateTime;
  private Long marketUnixTime;
  private LocalDateTime markDateTime;
  private Double marketPrice;
  private Double marketPriceChangePercent;
  private Double bid;
  private Long bidSize;
  private Double ask;
  private Long askSize;

  @ManyToOne
  @JoinColumn(name = "stock_id")
  private StockEntity stock;
}
