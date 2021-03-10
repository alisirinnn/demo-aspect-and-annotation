package com.example.ali.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.ali.demo.service.Calculator;

@SpringBootApplication
public class DemoAspectAndAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(DemoAspectAndAnnotationApplication.class,
				args);

		Calculator calculator = container.getBean(Calculator.class);

		calculator.pow(3, 4);
		calculator.sum(111, 222);

	}

}
