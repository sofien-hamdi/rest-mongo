package com.kt.examples.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kt.examples.rs")
public class RestMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMongoApplication.class, args);
	}
}
