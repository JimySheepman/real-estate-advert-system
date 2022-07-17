package com.example.advertservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableSwagger2
//@ServletComponentScan
public class AdvertServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertServiceApplication.class, args);
	}

}
