package com.bootcamp.demo_sb_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_yahoo_finance.entity.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long>{
  
}
