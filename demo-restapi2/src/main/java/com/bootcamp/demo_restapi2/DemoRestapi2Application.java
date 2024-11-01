package com.bootcamp.demo_restapi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // ! inject some other beans into context
public class DemoRestapi2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestapi2Application.class, args);
	}

}
