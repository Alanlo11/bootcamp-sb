package com.bootcamp.demo_sb_yahoo_finance.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.demo_sb_yahoo_finance.controller.PointOperation;
import com.bootcamp.demo_sb_yahoo_finance.infra.ApiResp;
import com.bootcamp.demo_sb_yahoo_finance.model.line.Base;
import com.bootcamp.demo_sb_yahoo_finance.model.line.PriceLine;
import com.bootcamp.demo_sb_yahoo_finance.service.StockTransService;
import com.fasterxml.jackson.core.JsonProcessingException;

public class PointController implements PointOperation{
  @Autowired
  private StockTransService stockTransService;

  @Override
  public ApiResp<PriceLine<Base>> getBasePrice(String symbol) throws JsonProcessingException {
    PriceLine<Base> priceline = stockTransService.getFiveMins(symbol);
    return ApiResp.<PriceLine<Base>>builder().ok().data(priceline).build();
  }
  

}
