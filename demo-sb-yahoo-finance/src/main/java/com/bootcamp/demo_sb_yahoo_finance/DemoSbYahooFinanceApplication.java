package com.bootcamp.demo_sb_yahoo_finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSbYahooFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSbYahooFinanceApplication.class, args);
	}

}
