package com.example.reportservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@EnableSwagger2
//@ServletComponentScan
public class ReportServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReportServiceApplication.class, args);
	}
}
