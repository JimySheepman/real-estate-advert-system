package com.example.authservice;

import com.example.authservice.dto.CreateUserRequestModel;
import com.example.authservice.models.Role;
import com.example.authservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService){
		return args -> {
/*
			CreateUserRequestModel rootUser =  CreateUserRequestModel
					.builder()
					.name("admin")
					.surname("test")
					.username("admin")
					.password("1234")
					.phoneNumber("12345")
					.email("admin@admin.com")
					.build();

			userService.save(rootUser,Role.USER);


			CreateUserRequestModel regularUser =  CreateUserRequestModel
					.builder()
					.name("John")
					.surname("test")
					.username("jdoe")
					.password("1234")
					.phoneNumber("12345")
					.email("test@test.com")
					.build();

			userService.save(regularUser, Role.USER);
*/
		};
	}
}
