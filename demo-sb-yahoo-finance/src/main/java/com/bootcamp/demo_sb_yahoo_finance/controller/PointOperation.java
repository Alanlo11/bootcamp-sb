package com.bootcamp.demo_sb_yahoo_finance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_sb_yahoo_finance.infra.ApiResp;
import com.bootcamp.demo_sb_yahoo_finance.model.line.Base;
import com.bootcamp.demo_sb_yahoo_finance.model.line.PriceLine;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PointOperation {
  @GetMapping(value = "/priceline")
  ApiResp<PriceLine<Base>> getBasePrice(@RequestParam String symbol) throws JsonProcessingException;
}
