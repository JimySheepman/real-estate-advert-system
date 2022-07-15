package com.example.authservice;

import com.example.authservice.models.Role;
import com.example.authservice.models.User;
import com.example.authservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

// @SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService){
		return args -> {
			userService.save(Role.builder().name("ROLE_USER").build());
			userService.save(Role.builder().name("ROLE_ADMIN").build());

			userService.save(User.builder().name("John").username("jdoe").password("1234").roles(new HashSet<>()).build());
			userService.save(User.builder().name("John").username("jdoe2").password("1234").roles(new HashSet<>()).build());

			userService.addRoleTo("jdoe","ROLE_USER");
			userService.addRoleTo("jdoe2","ROLE_ADMIN");
		};
	}
}
