package com.example.reportservice;

import com.example.reportservice.model.Report;
import com.example.reportservice.repository.ReportRepository;
import com.example.reportservice.service.ReportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ReportServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReportServiceApplication.class, args);
	}
}
