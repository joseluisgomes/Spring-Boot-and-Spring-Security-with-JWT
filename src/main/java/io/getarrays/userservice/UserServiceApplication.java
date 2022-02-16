package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveUser(
					new User(null,
							"Bruce Lee",
							"bruce_lee",
							"lee",
							new ArrayList<>()
					)
			);
			userService.saveUser(
					new User(null,
							"Michael Bon",
							"michael_bon",
							"bon",
							new ArrayList<>()
					)
			);
			userService.saveUser(
					new User(null,
							"Garalt de Rivia",
							"garalt_rivia",
							"rivia",
							new ArrayList<>()
					)
			);

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.addRoleToUser("bruce_lee", "ROLE_USER");
			userService.addRoleToUser("michael_bon", "ROLE_MANAGER");
			userService.addRoleToUser("garalt_rivia", "ROLE_ADMIN");
			userService.addRoleToUser("garalt_rivia", "ROLE_SUPER_ADMIN");
		};
	}
}
