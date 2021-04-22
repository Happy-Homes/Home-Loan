package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.lti")
@EntityScan("com.lti")
@SpringBootApplication
@EnableAutoConfiguration
public class HomeLoanProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeLoanProjectApplication.class, args);
	}

}
