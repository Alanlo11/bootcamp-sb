package com.bootcamp.demo_sb_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockEntity;

@Repository
public interface StockSymbolRepository extends JpaRepository<StockEntity, Long>{
  
}
