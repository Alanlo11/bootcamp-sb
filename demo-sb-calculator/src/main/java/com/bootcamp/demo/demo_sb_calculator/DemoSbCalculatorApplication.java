package com.bootcamp.demo.demo_sb_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// ! 1. @SpringBootConfiguration
// ! 2. @EnableAutoConfiguration
// ! 3. @ComponentScan

	// - What is Bean?
		// The object lifecycle is managed by someone, but not you.
		// In Spring, most of the beans are created during server start.

	// - What is Component? (能夠成為bean就係Component)
		// A class that used to create bean, we call it Component. i.e. @Controller
		// Spring既世界先有bean，java世界叫object

public class DemoSbCalculatorApplication {

	public static void main(String[] args) {
		String s = "abc"; // String object (heap memory)
		// static method
		SpringApplication.run(DemoSbCalculatorApplication.class, args);
	}

}
