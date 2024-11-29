package com.bootcamp.demo_sb_yahoo_finance.model.line;

import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PricePoint<T> {
  private LocalDateTime dateTime;
  private T price;

  @Override
  public boolean equals(Object obj){
    if(obj==this)
    return true;
    if(!(obj instanceof PricePoint))
    return false;
    PricePoint<?> pricePoint = (PricePoint<?>) obj;
    return Objects.equals(this.dateTime, pricePoint.getDateTime());
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.dateTime);
  }
}
