package com.bootcamp.demo_sb_yahoo_finance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;
import io.lettuce.core.dynamic.annotation.Param;


@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long>{
  
  @Query(value = "Select bid from StockPrice where symbol = :symbol")
  public Optional<StockPrice> findBySymbol(@Param("symbol") String symbol);

}
