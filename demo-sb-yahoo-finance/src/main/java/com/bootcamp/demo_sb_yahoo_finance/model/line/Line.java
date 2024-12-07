package com.bootcamp.demo_sb_yahoo_finance.model.line;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.data.convert.Jsr310Converters.LocalDateTimeToDateConverter;
import lombok.Builder;
import lombok.Getter;

// Generics Point<T extends ...>
// Point<T extends Point> ?

@Builder
public class Line<T extends Price> {
  private Type type; // 5min, 10min etc..

  @Builder.Default
  @Getter
  private List<Point<T>> points = new ArrayList<>();

  public boolean addPoint(Point<T> point) {
    return points.add(point);
  }

  public boolean addPoint(T price) {
    // read Type, if MIN_5, + 5 mins -> time
    LocalDateTime nextDateTime = null;
    return this.points.add(new Point<>(nextDateTime, price));
  }

  public void sort(){
    // ! you don't know the actual type of T
    // ! so you cannot use the attribute of Closed/Candle class
    }

  public static Line<Candle> FiveMinuteCandleLine(List<Point<Candle>> candles) {
    // validation ... throw run time exception
    // sorting for prices
    return Line.<Candle>builder()//
        .type(Line.Type.MIN_5)//
        .points(candles)//
        .build();
  }

  public static enum Type {
    MIN_5, MIN_15, DAY, WEEK, MONTH,;
  }

  public static void main(String[] args) {
    
  }
}
