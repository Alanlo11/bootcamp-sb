package com.bootcamp.demo_sb_yahoo_finance.model.line;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Transaction {
  private LocalDateTime time;
  private Double price;

  public Transaction(long epochSecond, Double price){
    this.time = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond), ZoneOffset.UTC);
    this.price = price;
  }
}
