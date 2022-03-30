package com.farmmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.farmmart")
public class FarmMartApplication {

	public static void main(String[] args) {

		SpringApplication.run(FarmMartApplication.class, args);
	}

}
