package com.bootcamp.demo_sb_yahoo_finance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long>{
  Optional<StockEntity> findBySymbol(String symbol);
}
