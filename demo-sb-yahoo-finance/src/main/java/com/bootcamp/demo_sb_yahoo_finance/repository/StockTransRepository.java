package com.bootcamp.demo_sb_yahoo_finance.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockTransEntity;
import io.lettuce.core.dynamic.annotation.Param;


@Repository
public interface StockTransRepository extends JpaRepository<StockTransEntity, Long>{
  @Query(value = "select p from StockTransEntity p where p.symbol = :symbol and p.marketUnixTime between :startEpoch and :endEpoch")
  List<StockTransEntity> findBySymbol(String symbol, long startEpoch, long endEpoch);

  @Query(value = "select max(p.marketUnixTime) from StockTransEntity p where p.symbol =:symbol")
  Long getMaxMarketTime(@Param("symbol") String symbol);
}
