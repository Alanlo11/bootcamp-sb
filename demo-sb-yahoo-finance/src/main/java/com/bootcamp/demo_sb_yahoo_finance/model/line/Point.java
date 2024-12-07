package com.bootcamp.demo_sb_yahoo_finance.model.line;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

// Generics POint<T extends ...>

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Point<T extends Price> {
  private LocalDateTime time; // timeZone, Serlizion同json唔夾, Java 8, x
  private T price; // y

  public static void main(String[] args) {
    Point<Candle> point = new Point<>();
    Point<Closed> point2 = new Point<>();

    Line<Candle> candleLine = new Line<>(null, null);
  }
}
